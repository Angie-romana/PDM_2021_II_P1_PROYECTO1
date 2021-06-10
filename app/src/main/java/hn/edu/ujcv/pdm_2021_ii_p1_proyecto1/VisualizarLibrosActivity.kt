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

        btnBuscarLibro.setOnClickListener {  inicializar() }


    }

    private fun inicializar() {
        var intent = intent
      valores= intent.getSerializableExtra("valores") as HashMap<Int, String>
        var id = txtNumeroLibro2.text.toString()
        var nombreLibro= ""
        var autor=""
        var fechaPublicacion= ""
        var editorial=""
        txvmostrarNombre.text = valores[1]


        for (i in 1..5){

        }

      for(valor in valores){
            val lista = valor.toString()
            nombreLibro = lista[1].toString()
            autor= lista[2].toString()
           fechaPublicacion = lista[3].toString()
            editorial=lista[4].toString()

            txvmostrarNombre.setText(nombreLibro)
            tvxMostrarAutor.setText(autor)
            txvMostrarFecha.setText(fechaPublicacion)
            txvMostrarEditorial.setText(editorial)


            if(valores.containsValue(id)){
                Toast.makeText(this, "Se HA ENCONTRADO $id", Toast.LENGTH_SHORT).show()
            }


        }
    }
}