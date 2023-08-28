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

        iniciarBoton(findViewById(R.id.boton1), TicTacToe::class.java)
        iniciarBoton(findViewById(R.id.boton2), randomGreet::class.java)
        iniciarBoton(findViewById(R.id.boton3), countries::class.java)
    }

    fun iniciarBoton(boton: Button, clase: Class<*>) {
        boton.setOnClickListener {
            if (clase == randomGreet::class.java) {
                val intent = Intent(this, randomGreet::class.java)
                intent.putExtra(
                    "idioma",
                    findViewById<Spinner>(R.id.spinner1).selectedItem.toString()
                )
                startActivity(intent)
            } else
                startActivity(Intent(this, clase))
        }
    }
}