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

    private fun iniciarJuego() {
        val listaBotones = listOf<Button>(
            findViewById(R.id.boton1),
            findViewById(R.id.boton2),
            findViewById(R.id.boton3),
            findViewById(R.id.boton4),
            findViewById(R.id.boton5),
            findViewById(R.id.boton6),
            findViewById(R.id.boton7),
            findViewById(R.id.boton8),
            findViewById(R.id.boton9)
        )

        var jugador = 1

        listaBotones.forEach { boton ->
            boton.setOnClickListener {
                jugador = juega(boton, jugador)
                boton.isEnabled = false
                hayGanador(listaBotones)
            }
        }

        findViewById<Button>(R.id.boton10).setOnClickListener {
            reiniciarBotones(listaBotones)
            jugador = 1
        }
    }

    private fun hayGanador(listaBotones: List<Button>) {
        for (i in 0..2)
            if (verificarVertical(i, listaBotones))
                return
        for (i in 0..6 step 3)
            if (verificarHorizontal(i, listaBotones))
                return
        for (i in 1..2)
            if (verificarDiagonal(listaBotones, i))
                return
    }

    private fun verificarHorizontal(inicial: Int, listaBotones: List<Button>): Boolean {
        var ganador = false
        if (recorridoH(inicial, listaBotones, "X") || recorridoH(inicial, listaBotones, "O")) {
            var botonesACambiar: List<Button> = listOf()
            for (i in inicial..(inicial + 2))
                botonesACambiar += listaBotones[i]
            cambiarColorBotonVerde(botonesACambiar)
            apagarBotones(listaBotones)
            ganador = true
        }
        return ganador
    }

    private fun verificarVertical(inicial: Int, listaBotones: List<Button>): Boolean {
        var ganador = false
        if (recorridoV(inicial, listaBotones, "X") || recorridoV(inicial, listaBotones, "O")) {
            var botonesACambiar: List<Button> = listOf()
            for (i in inicial..(inicial + 6) step 3)
                botonesACambiar += listaBotones[i]
            cambiarColorBotonVerde(botonesACambiar)
            apagarBotones(listaBotones)
            ganador = true
        }
        return ganador
    }

    private fun verificarDiagonal(listaBotones: List<Button>, sentido: Int): Boolean {
        var ganador = false
        if (recorridoD(listaBotones, "X", sentido) || recorridoD(listaBotones, "O", sentido)) {
            var botonesACambiar: List<Button> = listOf()
            if (sentido == 1)
                for (i in 0..8 step 4)
                    botonesACambiar += listaBotones[i]
            else
                for (i in 2..6 step 2)
                    botonesACambiar += listaBotones[i]
            cambiarColorBotonVerde(botonesACambiar)
            ganador = true
            apagarBotones(listaBotones)
        }
        return ganador
    }

    private fun recorridoH(
        inicial: Int, listaBotones: List<Button>, jugador: String
    ): Boolean {
        var coincide = true
        for (i in inicial..(inicial + 2))
            if (listaBotones[i].text != jugador) {
                coincide = false
                break
            }
        return coincide
    }

    private fun recorridoV(inicial: Int, listaBotones: List<Button>, jugador: String): Boolean {
        var coincide = true
        for (i in inicial..(inicial + 6) step 3)
            if (listaBotones[i].text != jugador) {
                coincide = false
                break
            }
        return coincide
    }

    private fun recorridoD(listaBotones: List<Button>, jugador: String, sentido: Int): Boolean {
        var coincide = true
        if (sentido == 1)
            for (i in 0..8 step 4) {
                if (listaBotones[i].text != jugador) {
                    coincide = false
                    break
                }
            }
        else
            for (i in 2..6 step 2)
                if (listaBotones[i].text != jugador) {
                    coincide = false
                    break
                }
        return coincide
    }


    private fun reiniciarBotones(listaBotones: List<Button>) {
        // cambiamos el color de los botones a su color default y los habilitamos
        listaBotones.forEach { boton ->
            boton.isEnabled = true
            boton.text = ""
        }
        cambiarColorBotonDefault(listaBotones)
    }

    private fun cambiarColorBotonDefault(listaBotones: List<Button>) {
        listaBotones.forEach { boton ->
            boton.backgroundTintList = resources.getColorStateList(R.color.blue_dark)
        }
    }

    private fun cambiarColorBotonVerde(listaBotones: List<Button>) {
        listaBotones.forEach { boton ->
            boton.backgroundTintList = resources.getColorStateList(R.color.green_light)
        }
    }

    private fun apagarBotones(
        listaBotones: List<Button>
    ) {
        // cambiamos el color de los botones a su color default y los habilitamos
        listaBotones.forEach { boton ->
            boton.isEnabled = false
        }
    }

    private fun juega(button: Button, jugador: Int): Int {
        val siguienteJugador: Int
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