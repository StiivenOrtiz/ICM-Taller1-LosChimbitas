package com.loschimbitas.icm_taller1_loschimbitas

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TicTacToe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tic_tac_toe)
        iniciarJuego()
    }

    fun iniciarJuego() {
        val boton1: Button = findViewById(R.id.boton1)
        val boton2: Button = findViewById(R.id.boton2)
        val boton3: Button = findViewById(R.id.boton3)
        val boton4: Button = findViewById(R.id.boton4)
        val boton5: Button = findViewById(R.id.boton5)
        val boton6: Button = findViewById(R.id.boton6)
        val boton7: Button = findViewById(R.id.boton7)
        val boton8: Button = findViewById(R.id.boton8)
        val boton9: Button = findViewById(R.id.boton9)
        val boton10: Button = findViewById(R.id.boton10)

        val listaBotones = listOf<Button>(
            boton1,
            boton2,
            boton3,
            boton4,
            boton5,
            boton6,
            boton7,
            boton8,
            boton9
        )

        var jugador: Int = 1

        boton10.setOnClickListener {
            reiniciarBotones(
                boton1,
                boton2,
                boton3,
                boton4,
                boton5,
                boton6,
                boton7,
                boton8,
                boton9
            )
            jugador = 1
        }

        listaBotones.forEach { boton ->
            boton.setOnClickListener {
                if (jugador == 1) {
                    boton.text = "X"
                    jugador = 2
                } else {
                    boton.text = "O"
                    jugador = 1
                }
                boton.isEnabled = false
                hayGanador(
                    boton1,
                    boton2,
                    boton3,
                    boton4,
                    boton5,
                    boton6,
                    boton7,
                    boton8,
                    boton9
                )
            }
        }
    }

    fun hayGanador(
        boton1: Button,
        boton2: Button,
        boton3: Button,
        boton4: Button,
        boton5: Button,
        boton6: Button,
        boton7: Button,
        boton8: Button,
        boton9: Button
    ): Boolean {

        var retorno: Boolean = false

        if (boton1.text == "X" && boton2.text == "X" && boton3.text == "X") {
            cambiarColorBotonVerde(boton1)
            cambiarColorBotonVerde(boton2)
            cambiarColorBotonVerde(boton3)
            retorno = true
        } else if (boton4.text == "X" && boton5.text == "X" && boton6.text == "X") {
            cambiarColorBotonVerde(boton4)
            cambiarColorBotonVerde(boton5)
            cambiarColorBotonVerde(boton6)
            retorno = true
        } else if (boton7.text == "X" && boton8.text == "X" && boton9.text == "X") {
            cambiarColorBotonVerde(boton7)
            cambiarColorBotonVerde(boton8)
            cambiarColorBotonVerde(boton9)
            retorno = true
        } else if (boton1.text == "X" && boton4.text == "X" && boton7.text == "X") {
            cambiarColorBotonVerde(boton1)
            cambiarColorBotonVerde(boton4)
            cambiarColorBotonVerde(boton7)
            retorno = true
        } else if (boton2.text == "X" && boton5.text == "X" && boton8.text == "X") {
            cambiarColorBotonVerde(boton2)
            cambiarColorBotonVerde(boton5)
            cambiarColorBotonVerde(boton8)
            retorno = true
        } else if (boton3.text == "X" && boton6.text == "X" && boton9.text == "X") {
            cambiarColorBotonVerde(boton3)
            cambiarColorBotonVerde(boton6)
            cambiarColorBotonVerde(boton9)
            retorno = true
        } else if (boton1.text == "X" && boton5.text == "X" && boton9.text == "X") {
            cambiarColorBotonVerde(boton1)
            cambiarColorBotonVerde(boton5)
            cambiarColorBotonVerde(boton9)
            retorno = true
        } else if (boton3.text == "X" && boton5.text == "X" && boton7.text == "X") {
            cambiarColorBotonVerde(boton3)
            cambiarColorBotonVerde(boton5)
            cambiarColorBotonVerde(boton7)
            retorno = true
        }
        return retorno
    }

    fun reiniciarBotones(
        boton1: Button,
        boton2: Button,
        boton3: Button,
        boton4: Button,
        boton5: Button,
        boton6: Button,
        boton7: Button,
        boton8: Button,
        boton9: Button
    ) {
        // hacemos una lista de los botones
        val listaBotones = listOf<Button>(
            boton1,
            boton2,
            boton3,
            boton4,
            boton5,
            boton6,
            boton7,
            boton8,
            boton9
        )

        // cambiamos el color de los botones a su color default y los habilitamos
        listaBotones.forEach { boton ->
            cambiarColorBotonDefault(boton)
            boton.isEnabled = true
            boton.text = ""
        }
    }

    fun cambiarColorBotonDefault(boton: Button) {
        boton.backgroundTintList = resources.getColorStateList(R.color.blue_dark)
    }

    fun cambiarColorBotonVerde(boton: Button) {
        boton.backgroundTintList = resources.getColorStateList(R.color.green_light)
    }
}