package com.loschimbitas.icm_taller1_loschimbitas // Declarar el paquete

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.loschimbitas.icm_taller1_loschimbitas.Modelo.Pais

class showCountry : AppCompatActivity() { // Actividad para mostrar la información de un país
    override fun onCreate(savedInstanceState: Bundle?) { // Al crear la actividad
        super.onCreate(savedInstanceState) // Ejecutar el constructor de la clase padre
        setContentView(R.layout.show_country) // Establecer el layout
        cargar() // Cargar la información del país
    }

    fun cargar() { // Cargar la información del país
        val pais = intent.getSerializableExtra("pais") as? Pais // Obtener el país
        val textView1: TextView = findViewById(R.id.textView1) // Nombre del país
        val boton1: Button = findViewById(R.id.buton1) // Botón para ir a la siguiente actividad

        if (pais != null) { // Si se pudo cargar el país
            textView1.text = pais.nombre_pais // Establecer el nombre del país
            findViewById<TextView>(R.id.textView3).text =
                pais.capital // Establecer la capital del país
            findViewById<TextView>(R.id.textView5).text =
                pais.nombre_pais_int // Establecer el nombre internacional del país
            findViewById<TextView>(R.id.textView7).text = pais.sigla // Establecer la sigla del país

            Glide.with(this) // Cargar la bandera del país
                .load("https://flagcdn.com/w2560/${pais.sigla.lowercase()}.png") // URL de la bandera
                .into(findViewById<ImageView>(R.id.imageView1)) // ImageView para mostrar la bandera

            boton1.setOnClickListener { // Al hacer clic en el botón
                val intent = intent
                intent.setClass(
                    this,
                    ExtraCountryInformation::class.java
                ) // Establecer la siguiente actividad
                intent.putExtra(
                    "pais",
                    pais.nombre_pais_int
                ) // Establecer el nombre internacional del país
                startActivity(intent) // Iniciar la siguiente actividad
            }
        } else { // Si no se pudo cargar el país
            textView1.text = "No se pudo cargar el país" // Establecer el nombre del país
            boton1.visibility = Button.INVISIBLE // Hacer invisible el botón
            boton1.isEnabled = false // Deshabilitar el botón
            Log.e("showCountry", "No se pudo cargar el país.") // Mostrar mensaje de error
        }
    }
}