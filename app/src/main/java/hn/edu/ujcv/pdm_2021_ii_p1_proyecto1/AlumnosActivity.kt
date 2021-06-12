package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alumnos.*
import kotlinx.android.synthetic.main.activity_alumnos.txtNumeroCuenta
import kotlinx.android.synthetic.main.activity_prestamo_libros.*
import java.util.*
import kotlin.collections.HashMap

class AlumnosActivity : AppCompatActivity() {
    var alumno: HashMap<Int,String> = hashMapOf()
    var numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnos)
        inicializar()
        imvFechaIngreso.setOnClickListener { capturarFecha() }
        btnSave.setOnClickListener { guardar() }
        btnVer.setOnClickListener { visualizar() }
    }

    private fun guardar(){
        val dato = StringBuilder()
        numero+=1
        dato.append(txtNumeroCuenta.text.toString()).append("|")
        dato.append(txtNombreAlumno.text.toString().trim()).append("|")
        dato.append(txtNombreCarrera.text.toString().trim()).append("|")
        dato.append(txtFechaIngreso.text.toString()).append("|")
        dato.append(txtCorreo.text.toString())
        alumno.put(numero,dato.toString())
        noVacio()
        if (noVacio()== true){
            btnVer.isEnabled = true
            Toast.makeText(this, "Se ha guardado al nuevo alumno", Toast.LENGTH_SHORT).show()
            limpiarCampos()
        }
    }

    fun noVacio() : Boolean{
        if(txtNumeroCuenta.text.toString().isEmpty()) {
            txtNumeroCuenta.error ="Debe rellenar el número de cuenta del alumno"
            return false
        }else if(txtNombreAlumno.text.toString().isEmpty()){
            txtNombreAlumno.error = "Debe rellenar el nombre del alumno"
            return false
        }

        if(txtNombreCarrera.text.toString().isEmpty()) {
            txtNombreCarrera.error ="Debe rellenar el autor"
            return false
        }
        if(txtFechaIngreso.text.toString().isEmpty()) {
            txtFechaIngreso.error ="Debe seleccionar una fecha dando click en el ícono"
            return false
        }
        if(txtCorreo.text.toString().isEmpty()) {
            txtCorreo.error ="Debe rellenar el correo electrónico"
            return false
        }
        return true
    }

    private fun visualizar() {
        val intent = Intent(this, VisualizarAlumnosActivity::class.java)
        intent.putExtra("alumnos", alumno)
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
            txtFechaIngreso.setText(""+mDia+"/"+(mMes.toInt() +1)+"/"+mAño)

        },año,mes-1,dia)
        dpd.show()
    }
    private fun inicializar() {
        btnVer.isEnabled = false
    }

    private fun limpiarCampos(){
        txtNumeroCuenta.setText("")
        txtNombreAlumno.setText("")
        txtNombreCarrera.setText("")
        txtFechaIngreso.setText("")
        txtCorreo.setText("")

    }
}