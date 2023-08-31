package com.loschimbitas.icm_taller1_loschimbitas // Declarar el paquete

import android.os.Bundle // Importar clase para manejar el Bundle
import android.widget.TextView // Importar clase para manejar el TextView
import androidx.appcompat.app.AppCompatActivity // Importar clase para manejar la actividad

class randomGreet : AppCompatActivity() { // Actividad para mostrar un saludo aleatorio
    override fun onCreate(savedInstanceState: Bundle?) { // Al crear la actividad
        super.onCreate(savedInstanceState) // Ejecutar el constructor de la clase padre
        setContentView(R.layout.random_greet) // Establecer el layout

        val idioma = intent.getStringExtra("idioma") // Obtener el idioma
        if (idioma != null) { // Si se pudo obtener el idioma
            findViewById<TextView>(R.id.textView1).text =
                findViewById<TextView>(R.id.textView1).text.toString() + " " + idioma // Establecer el idioma
            findViewById<TextView>(R.id.textView2).text = getString( // Establecer el saludo
                resources.getIdentifier( // Obtener el identificador del saludo
                    "random_greet_$idioma", // Nombre del saludo
                    "string", // Tipo de identificador
                    "com.loschimbitas.icm_taller1_loschimbitas" // Nombre del paquete
                )
            )
        }
    }
}