package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_visualizar_alumnos.*
import kotlinx.android.synthetic.main.activity_visualizar_libros.*
import kotlinx.android.synthetic.main.activity_visualizar_prestamo_libros.*

class VisualizarAlumnosActivity : AppCompatActivity() {
    var alumnos: HashMap<Int,String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_alumnos)
        inicializar()

        btnBuscarA.setOnClickListener{llenar()}

    }
    private fun inicializar() {
        var intent = intent
        alumnos = intent.getSerializableExtra("alumnos") as HashMap<Int, String>

    }

   fun llenar() {
       var numeroCuenta:String
       var nombreAlumno: String
       var nombreCarrera: String
       var fechaPublicacion: String
       var correo: String
       txtNumeroCuenta.setText("")
       txtNumeroPrestamo.setText("")
       txtMostrarFechaPrestamo.setText("")
       txtNumeroLibroPrestado.setText("")
       txtFechaDevolucionLibro.setText("")
       for(valor in alumnos){
           val lista = valor.toString().split("|","=")

           numeroCuenta= lista[1]
           nombreAlumno = lista[2]
           nombreCarrera= lista[3]
           fechaPublicacion = lista[4]
           correo=lista[5]
           if (txtMBuscar.text.toString().equals(numeroCuenta)) {
               txtMNumero.setText(numeroCuenta)
               txtMNombre.setText(nombreAlumno)
               txtMCarrera.setText(nombreCarrera)
               txtMFecha.setText(fechaPublicacion)
               txtMCorreo.setText(correo)
               return
           }
       }
       Toast.makeText(this, "No se ha encontrado el número de libro", Toast.LENGTH_SHORT).show()
    }
}