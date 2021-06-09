package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_prestamo_libros.*
import java.util.*

class PrestamoLibrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prestamo_libros)
        imvFechaPrestamo.setOnClickListener { capturarFecha() }
        btnGuardar.setOnClickListener { guardar() }
        }


    private fun guardar(){

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

   /* fun validarFecha(dia:String,mes:String, año:String){
        var nuevoMes: Int
        var nuevoDia:Int
        var nuevoAño:Int
        var mesesCon30Dias = arrayOf(1,3,5,7,8,10,12)
        var mesesCon31Dias = arrayListOf<Int>(4,6,8,11)
        var mesesCon28Dias = arrayOf(2)
        if(dia.toInt()>= 28){
            if(mes.toInt() == 2){
                nuevoAño = año.toInt()
                nuevoMes = 3
                nuevoDia = 3
            }
        if(dia.toInt() >=30){
            if(mes.toInt()==1 || mes.toInt()==3 || mes.toInt()==5 || mes.toInt()==7
                || mes.toInt()==8 || mes.toInt()==10 || mes.toInt()==12){
                if(mes.toInt()==12){
                    nuevoAño = año.toInt() + 1
                    nuevoMes = 1
                    nuevoDia = (30 - )
                }

            }
        }
        }
    }*/
}