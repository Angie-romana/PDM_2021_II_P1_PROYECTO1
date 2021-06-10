package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_libros.*


open class LibrosActivity : AppCompatActivity(),View.OnClickListener {
    var valores: HashMap<Int, String> = hashMapOf()
    var numero = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)

        inicializar()

        btnGuardar.setOnClickListener { guardar() }
        btnVisualizar.setOnClickListener { enviarDatos() }

    }

    fun noNumeros(dato:String):Boolean{

        if(dato.contentEquals("123456789")||dato.contentEquals("<,.*|-_!#$%&/()=?¡¡¿+")){
            return false
        }
      return true

    }



    fun minLength():Boolean{
        if(txtNumeroLibro.text.toString().length <5) {
            txtNumeroLibro.error ="El número debe de ser 5 caracteres"
            return false
        }
        if(txtNombreLibro.text.toString().length <3) {
            txtNombreLibro.error ="No puede ser menor de 3 characteres"
            return false
        }
        if(txtAutor.text.toString().length <6) {
            txtAutor.error ="No puede ser menor de 6 characteres"
            return false
        }
        if(txtFechaPublicacion.text.toString().length <6) {
            txtFechaPublicacion.error ="La fecha debe incluir día/mes/año"
            return false
        }
        if(txtEditorial.text.toString().length <3) {
            txtEditorial.error ="No puede ser menor de 3 characteres"
            return false
        }
        return true
    }


    fun noVacio() : Boolean{
        if(txtNumeroLibro.text.toString().isEmpty()) {
            txtNumeroLibro.error ="Debe rellenar número de libro"
            return false
        }else if(txtNombreLibro.text.toString().isEmpty()){
            txtNombreLibro.error = "Debe rellenar el Nombre"
            return false
        }

        if(txtAutor.text.toString().isEmpty()) {
            txtAutor.error ="Debe rellenar el autor"
            return false
        }
        if(txtFechaPublicacion.text.toString().isEmpty()) {
            txtFechaPublicacion.error ="Debe rellenar la fecha"
            return false
        }
        if(txtEditorial.text.toString().isEmpty()) {
            txtEditorial.error ="Debe rellenar la fecha"
            return false
        }



        return true

    }



    private fun enviarDatos() {
        val intent = Intent(this,VisualizarLibrosActivity::class.java)
        intent.putExtra("valores",valores)
        startActivity(intent)
    }

    private fun guardar() {

        var dato = StringBuilder()
        numero += 1
        dato.append(txtNumeroLibro.text.toString())
        dato.append(txtNombreLibro.text.toString())
        dato.append(txtAutor.text.toString())
        dato.append(txtFechaPublicacion.text.toString())
        dato.append(txtEditorial.text.toString())
        valores.put(numero, dato.toString())
        btnGuardar.isEnabled = true

        noVacio()
        minLength()
        if(noNumeros(txtNombreLibro.toString())){
            txtNombreLibro.error ="Solo se permiten letras"
        }
        if (noVacio()== true && minLength()==true){
            btnVisualizar.isEnabled = true
            Toast.makeText(this, "Se ha Guardado correctamente libros", Toast.LENGTH_SHORT).show()
        }





    }

    private fun inicializar() {

        btnVisualizar.isEnabled=false
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnGuardar->{
                if(noVacio()){
                   Toast.makeText(applicationContext,"REALIZADO GUARDADO" , Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}
class Validaciones():LibrosActivity(){



}




