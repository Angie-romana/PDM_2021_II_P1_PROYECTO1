package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_prestamo_libros.*
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
            var fechaPrestamo:String
            for(prestamo in prestamos) {
                val lista = prestamo.toString().split("|","=")
                numeroCuenta = lista[1].toString()
                fechaPrestamo = lista[4]
                if (txtBuscar.text.toString().equals(numeroCuenta)) {
                    txtNumeroCuenta.setText(numeroCuenta)
                    txtMostrarFechaPrestamo.setText(fechaPrestamo)

                        /* Numero cuenta ->1
                        Numero prestamo ->2
                        Numero libro ->3
                        Fecha prestamo ->4
                        fecha devolucion -> 5*/
                }

            }
        }
    }
