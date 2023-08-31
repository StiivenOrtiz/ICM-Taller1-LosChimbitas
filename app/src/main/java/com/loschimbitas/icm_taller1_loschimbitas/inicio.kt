package com.loschimbitas.icm_taller1_loschimbitas // Declarar el paquete

import android.content.Intent // Importar clase para manejar el Intent
import android.os.Bundle // Importar clase para manejar el Bundle
import android.widget.Button // Importar clase para manejar el Button
import android.widget.Spinner // Importar clase para manejar el Spinner
import androidx.appcompat.app.AppCompatActivity // Importar clase para manejar la actividad

class inicio : AppCompatActivity() { // Actividad para mostrar el menú principal
    override fun onCreate(savedInstanceState: Bundle?) { // Al crear la actividad
        super.onCreate(savedInstanceState) // Ejecutar el constructor de la clase padre
        setContentView(R.layout.inicio) // Establecer el layout

        iniciarBoton(findViewById(R.id.boton1), TicTacToe::class.java) // Iniciar el botón
        iniciarBoton(findViewById(R.id.boton2), randomGreet::class.java) // Iniciar el botón
        iniciarBoton(findViewById(R.id.boton3), countries::class.java) // Iniciar el botón
    }

    fun iniciarBoton(boton: Button, clase: Class<*>) { // Iniciar el botón
        boton.setOnClickListener { // Al hacer clic en el botón
            if (clase == randomGreet::class.java) { // Si se va a iniciar la actividad de saludo aleatorio
                val intent = Intent(this, randomGreet::class.java) // Crear el intent
                intent.putExtra( // Establecer el idioma
                    "idioma", // Nombre del dato
                    findViewById<Spinner>(R.id.spinner1).selectedItem.toString() // Valor del dato
                )
                startActivity(intent) // Iniciar la actividad
            } else
                startActivity(Intent(this, clase)) // Iniciar la actividad
        }
    }
}