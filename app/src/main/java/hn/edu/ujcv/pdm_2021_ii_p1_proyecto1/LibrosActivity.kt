package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_libros.*
import kotlinx.android.synthetic.main.activity_libros.btnGuardar
import kotlinx.android.synthetic.main.activity_libros.btnVisualizar
import kotlinx.android.synthetic.main.activity_libros.txtNumeroLibro
import kotlinx.android.synthetic.main.activity_prestamo_libros.*
import java.util.*
import kotlin.collections.HashMap


open class LibrosActivity : AppCompatActivity(),View.OnClickListener {
    var valores: HashMap<Int, String> = hashMapOf()
    var numero:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)

        inicializar()
        txvFecha.setOnClickListener { capturarFecha() }
        btnGuardar.setOnClickListener { guardar() }
        btnVisualizar.setOnClickListener { enviarDatos() }

    }

    private fun capturarFecha() {
        //Calendar
        val c = Calendar.getInstance()
        val date = Date()

        var año = c.get(Calendar.YEAR)
        var mes = c.get(Calendar.MONTH)+1
        var dia = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, { view, mAño, mMes, mDia ->
            txtFechaPublicacion.setText(""+mDia+"/"+(mMes.toInt() +1)+"/"+mAño)

        },año,mes-1,dia)
        dpd.show()

    }
    fun parecidos(dato: String){

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
            txtEditorial.error ="Debe rellenar la editorial"
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
        dato.append(txtNumeroLibro.text.toString()).append("|")
        dato.append(txtNombreLibro.text.toString().trim()).append("|")
        dato.append(txtAutor.text.toString().trim()).append("|")
        dato.append(txtFechaPublicacion.text.toString()).append("|")
        dato.append(txtEditorial.text.toString().trim())
        valores.put(numero, dato.toString())

        noVacio()
        minLength()

     /*   while(contieneNumero(txtEditorial.text.toString())){
            txtEditorial.error ="La editorial no puede contener números"
        }*/

        if (noVacio()== true && minLength()==true){
            btnVisualizar.isEnabled = true
            Toast.makeText(this, "Se ha guardado correctamente la información", Toast.LENGTH_SHORT).show()
            limpiar()
        }


    }
/*    fun contieneNumero(texto:String):Boolean{
        val prueba = texto.split(' ');
        var c :Char
        for(i in 1..texto.length){
            c = texto.get(i)
            if(c.isDigit()){
                return true
            }
        }
        return false
    }*/
    fun limpiar(){
        txtNumeroLibro.setText("")
        txtNombreLibro.setText("")
        txtAutor.setText("")
        txtFechaPublicacion.setText("")
        txtEditorial.setText("")
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




