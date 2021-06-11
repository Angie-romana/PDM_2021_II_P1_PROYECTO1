package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_visualizar_prestamo_libros.*
import kotlinx.android.synthetic.main.activity_visualizar_prestamo_libros.txtNumeroCuenta


class VisualizarPrestamoLibrosActivity : AppCompatActivity() {
    var prestamos: HashMap<Int,String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_prestamo_libros)
        inicializar()
        btnBuscar.setOnClickListener { llenar() }
    }

    private fun inicializar() {
        var intent = intent
        prestamos = intent.getSerializableExtra("prestamos") as HashMap<Int, String>
    }

        private fun llenar(){
            var numeroCuenta:String
            var numeroPrestamo:String
            var numeroLibro:String
            var fechaPrestamo:String
            var fechaDevolucion:String
            txtNumeroCuenta.setText("")
            txtNumeroPrestamo.setText("")
            txtMostrarFechaPrestamo.setText("")
            txtNumeroLibroPrestado.setText("")
            txtFechaDevolucionLibro.setText("")
            for(prestamo in prestamos) {
                val lista = prestamo.toString().split("|","=")
                numeroCuenta = lista[1]
                numeroPrestamo = lista[2]
                numeroLibro = lista[3]
                fechaPrestamo = lista[4]
                fechaDevolucion = lista[5]
                if (txtBuscar.text.toString().equals(numeroCuenta)) {
                    txtNumeroCuenta.setText(numeroCuenta)
                    txtNumeroPrestamo.setText(numeroPrestamo)
                    txtMostrarFechaPrestamo.setText(fechaPrestamo)
                    txtNumeroLibroPrestado.setText(numeroLibro)
                    txtFechaDevolucionLibro.setText(fechaDevolucion)
                    return
                }
            }
            Toast.makeText(this, "No se ha encontrado este número de cuenta", Toast.LENGTH_SHORT).show()
        }

    }
