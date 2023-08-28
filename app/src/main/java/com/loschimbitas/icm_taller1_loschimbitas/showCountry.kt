package com.loschimbitas.icm_taller1_loschimbitas

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.loschimbitas.icm_taller1_loschimbitas.Modelo.Pais
import com.murgupluoglu.flagkit.FlagKit

class showCountry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_country)
        cargar()
    }

    fun cargar() {
        val pais = intent.getSerializableExtra("pais") as? Pais
        val textView1: TextView = findViewById(R.id.textView1) // Nombre del país
        val boton1: Button = findViewById(R.id.buton1) // Botón para ir a la siguiente actividad

        if (pais != null) {
            textView1.text = pais.nombre_pais
            findViewById<TextView>(R.id.textView3).text = pais.capital
            findViewById<TextView>(R.id.textView5).text = pais.nombre_pais_int
            findViewById<TextView>(R.id.textView7).text = pais.sigla
            findViewById<ImageView>(R.id.imageView1).setImageResource(
                FlagKit.getResId(
                    this,
                    pais.sigla
                )
            )

            boton1.setOnClickListener {
                val intent = intent
                intent.setClass(this, ExtraCountryInformation::class.java)
                intent.putExtra("pais", pais.nombre_pais_int)
                startActivity(intent)
            }
        } else {
            textView1.text = "No se pudo cargar el país"
            boton1.visibility = Button.INVISIBLE
            boton1.isEnabled = false
            Log.e("showCountry", "No se pudo cargar el país.")
        }
    }
}