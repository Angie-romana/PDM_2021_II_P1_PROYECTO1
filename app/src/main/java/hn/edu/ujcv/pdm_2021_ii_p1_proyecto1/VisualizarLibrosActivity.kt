package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_libros.*
import kotlinx.android.synthetic.main.activity_visualizar_libros.*

class VisualizarLibrosActivity : AppCompatActivity() {
    var valores: HashMap<Int,String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_libros)
        inicializar()

        btnBuscarLibro.setOnClickListener{llenar()}
        txvIconoNumeroCuenta.setOnClickListener { borrar() }


    }

    private fun borrar() {
        txtBuscar.setText("")
        txtMostrarNumero.setText("")
        txtMostrarNombre.setText("")
        txtMostrarAutor.setText("")
        txtMostrarFecha.setText("")
        txtMostrarEditorial.setText("")
    }

    private fun inicializar() {
        var intent = intent
        valores = intent.getSerializableExtra("valores") as HashMap<Int, String>
    }

    fun llenar(){
     var numeroLibro:String
        var nombreLibro: String
        var autor: String
        var fechaPublicacion: String
        var editorial: String


      for(valor in valores){
          val lista = valor.toString().split("|","=")
          //numeroLibro= txtBuscar.text.toString().toInt()
          numeroLibro= lista[1]
          nombreLibro = lista[2]
          autor= lista[3]
          fechaPublicacion = lista[4]
          editorial=lista[5]
                  if (txtBuscar.text.toString().equals(numeroLibro)) {
                      txtMostrarNumero.setText(numeroLibro)
                      txtMostrarNombre.setText(nombreLibro)
                      txtMostrarAutor.setText(autor)
                      txtMostrarFecha.setText(fechaPublicacion)
                      txtMostrarEditorial.setText(editorial)
                      return
                  }
        }
        Toast.makeText(this, "No se ha encontrado el número de libro", Toast.LENGTH_SHORT).show()
        txtBuscar.setText("")
    }
}