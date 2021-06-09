package hn.edu.ujcv.pdm_2021_ii_p1_proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLibros.setOnClickListener {
            val intent = Intent(this, LibrosActivity::class.java)
            startActivity(intent)
        }
    }
}