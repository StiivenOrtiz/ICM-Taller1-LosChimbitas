package com.loschimbitas.icm_taller1_loschimbitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        val boton1: Button = findViewById(R.id.boton1)
        val boton2: Button = findViewById(R.id.boton2)
        val boton3: Button = findViewById(R.id.boton3)
        val spinner1: Spinner = findViewById(R.id.spinner1)

        // Cambiar a la actividad de TicTacToe
        boton1.setOnClickListener {
            startActivity(Intent(this, TicTacToe::class.java))
        }

        // Cambiar a la actividad de Random Greet
        boton2.setOnClickListener {
            val intent = Intent(this, randomGreet::class.java)
            intent.putExtra("idioma", spinner1.selectedItem.toString())
            startActivity(intent)
        }

        // Cambiar a la actividad de Countries
        boton3.setOnClickListener {
           val intent = Intent(this, countries::class.java)
           startActivity(intent)
        }
    }
}