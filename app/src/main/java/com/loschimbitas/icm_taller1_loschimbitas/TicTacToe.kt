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
            reiniciarBotones(listaBotones)
            jugador = 1
        }

        listaBotones.forEach { boton ->
            boton.setOnClickListener {
                jugador = juega(boton, jugador)
                boton.isEnabled = false
                hayGanador(listaBotones)
            }
        }
    }

    fun hayGanador(listaBotones: List<Button>): Boolean {
        var retorno: Boolean = false

        if ((listaBotones[0].text == "X" && listaBotones[1].text == "X" && listaBotones[2].text == "X") || (listaBotones[0].text == "O" && listaBotones[1].text == "O" && listaBotones[2].text == "O")) {
            val listaBotonesCambiarColor = listOf(listaBotones[0], listaBotones[1], listaBotones[2])
            cambiarColorBotonVerde(listaBotonesCambiarColor)
            retorno = true
        } else if ((listaBotones[3].text == "X" && listaBotones[4].text == "X" && listaBotones[5].text == "X") || (listaBotones[3].text == "O" && listaBotones[4].text == "O" && listaBotones[5].text == "O")) {
            val listaBotonesCambiarColor = listOf(listaBotones[3], listaBotones[4], listaBotones[5])
            cambiarColorBotonVerde(listaBotonesCambiarColor)
            retorno = true
        } else if ((listaBotones[6].text == "X" && listaBotones[7].text == "X" && listaBotones[8].text == "X") || (listaBotones[6].text == "O" && listaBotones[7].text == "O" && listaBotones[8].text == "O")) {
            val listaBotonesCambiarColor = listOf(listaBotones[6], listaBotones[7], listaBotones[8])
            cambiarColorBotonVerde(listaBotonesCambiarColor)
            retorno = true
        } else if ((listaBotones[0].text == "X" && listaBotones[3].text == "X" && listaBotones[6].text == "X") || (listaBotones[0].text == "O" && listaBotones[3].text == "O" && listaBotones[6].text == "O")) {
            val listaBotonesCambiarColor = listOf(listaBotones[0], listaBotones[3], listaBotones[6])
            cambiarColorBotonVerde(listaBotonesCambiarColor)
            retorno = true
        } else if ((listaBotones[1].text == "X" && listaBotones[4].text == "X" && listaBotones[7].text == "X") || (listaBotones[1].text == "O" && listaBotones[4].text == "O" && listaBotones[7].text == "O")) {
            val listaBotonesCambiarColor = listOf(listaBotones[1], listaBotones[4], listaBotones[7])
            cambiarColorBotonVerde(listaBotonesCambiarColor)
            retorno = true
        } else if ((listaBotones[2].text == "X" && listaBotones[5].text == "X" && listaBotones[8].text == "X") || (listaBotones[2].text == "O" && listaBotones[5].text == "O" && listaBotones[8].text == "O")) {
            val listaBotonesCambiarColor = listOf(listaBotones[2], listaBotones[5], listaBotones[8])
            cambiarColorBotonVerde(listaBotonesCambiarColor)
            retorno = true
        } else if ((listaBotones[0].text == "X" && listaBotones[4].text == "X" && listaBotones[8].text == "X") || (listaBotones[0].text == "O" && listaBotones[4].text == "O" && listaBotones[8].text == "O")) {
            val listaBotonesCambiarColor = listOf(listaBotones[0], listaBotones[4], listaBotones[8])
            cambiarColorBotonVerde(listaBotonesCambiarColor)
            retorno = true
        } else if ((listaBotones[2].text == "X" && listaBotones[4].text == "X" && listaBotones[6].text == "X") || (listaBotones[2].text == "O" && listaBotones[4].text == "O" && listaBotones[6].text == "O")) {
            val listaBotonesCambiarColor = listOf(listaBotones[2], listaBotones[4], listaBotones[6])
            cambiarColorBotonVerde(listaBotonesCambiarColor)
            retorno = true
        }

        if (retorno)
            apagarBotones(listaBotones)

        return retorno
    }

    fun reiniciarBotones(listaBotones: List<Button>) {
        // cambiamos el color de los botones a su color default y los habilitamos
        listaBotones.forEach { boton ->
            boton.isEnabled = true
            boton.text = ""
        }
        cambiarColorBotonDefault(listaBotones)
    }

    fun cambiarColorBotonDefault(listaBotones: List<Button>) {
        listaBotones.forEach { boton ->
            boton.backgroundTintList = resources.getColorStateList(R.color.blue_dark)
        }
    }

    fun cambiarColorBotonVerde(listaBotones: List<Button>) {
        listaBotones.forEach { boton ->
            boton.backgroundTintList = resources.getColorStateList(R.color.green_light)
        }
    }

    fun apagarBotones(
        listaBotones: List<Button>
    ) {
        // cambiamos el color de los botones a su color default y los habilitamos
        listaBotones.forEach { boton ->
            boton.isEnabled = false
        }
    }

    fun juega(button: Button, jugador: Int): Int {
        var siguienteJugador: Int = 0
        if (jugador == 1) {
            button.text = "X"
            siguienteJugador = 2
        } else {
            button.text = "O"
            siguienteJugador = 1
        }
        button.isEnabled = false
        return siguienteJugador
    }
}