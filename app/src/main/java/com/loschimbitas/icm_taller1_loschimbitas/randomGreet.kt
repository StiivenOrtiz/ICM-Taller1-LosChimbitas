package com.loschimbitas.icm_taller1_loschimbitas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class randomGreet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.random_greet)

        val textView1: TextView = findViewById(R.id.textView1)
        val textView2: TextView = findViewById(R.id.textView2)
        val idioma = intent.getStringExtra("idioma")

        textView1.text = textView1.text.toString() + " " + idioma
        if (idioma != null) {
            saludar(idioma, textView2)
        }
    }

    fun saludar(idioma: String, textView: TextView) {
        var saludo: String = ""
        val idiomas = resources.getStringArray(R.array.inicio_spinner1_values)
        //Si el idioma seleccionado coincide con el idioma del array, se asigna el saludo correspondiente
        idiomas.forEach { i ->
            if (idioma == i) {
                saludo = getString(
                    resources.getIdentifier(
                        "random_greet_" + i,
                        "string",
                        "com.loschimbitas.icm_taller1_loschimbitas"
                    )
                )
            }
        }
        textView.text = saludo
    }
}