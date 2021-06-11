package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_prestamo_libros.*
import java.util.Calendar
import java.util.Date

class PrestamoLibrosActivity : AppCompatActivity() {
    var prestamos: HashMap<Int,String> = hashMapOf()
    var numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prestamo_libros)
        inicializar()
        imvFechaPrestamo.setOnClickListener { capturarFecha() }
        btnGuardar.setOnClickListener { guardar() }
        btnVisualizar.setOnClickListener { visualizar() }
        }


    private fun guardar(){
        val dato = StringBuilder()
        numero+=1
        dato.append(txtNumeroCuenta.text.toString().trim()).append("|")
        dato.append(txtNumeroPrestamoLibro.text.toString()).append("|")
        dato.append(txtNumeroLibro.text.toString()).append("|")
        dato.append(txtFechaPrestamo.text.toString()).append("|")
        dato.append(txtFechaDevolucion.text.toString())
        prestamos.put(numero,dato.toString())
        btnVisualizar.isEnabled = true
        Toast.makeText(this, "Se ha guardado el préstamo del libro", Toast.LENGTH_SHORT).show()
        limpiarCampos()
    }

    private fun visualizar() {
        val intent = Intent(this, VisualizarPrestamoLibrosActivity::class.java)
        intent.putExtra("prestamos",prestamos)
        startActivity(intent)
    }

    private fun capturarFecha() {
        //Calendar
        val c = Calendar.getInstance()
        val date = Date()

        var año = c.get(Calendar.YEAR)
        var mes = c.get(Calendar.MONTH)+1
        var dia = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, { view, mAño, mMes, mDia ->
            txtFechaPrestamo.setText(""+mDia+"/"+(mMes.toInt() +1)+"/"+mAño)
            c.set(mAño,mMes,(mDia+3))
            dia = c.get(Calendar.DAY_OF_MONTH)
            var año = c.get(Calendar.YEAR)
            var mes = c.get(Calendar.MONTH) + 1
            txtFechaDevolucion.setText(""+dia+"/"+mes+"/"+año)
        },año,mes-1,dia)
        dpd.show()
    }

    private fun inicializar() {
        btnVisualizar.isEnabled = false
    }

    private fun limpiarCampos(){
        txtNumeroCuenta.setText("")
        txtNumeroPrestamoLibro.setText("")
        txtNumeroLibro.setText("")
        txtFechaPrestamo.setText("")
        txtFechaDevolucion.setText("")
        txtNumeroLibro.requestFocus()
    }
}