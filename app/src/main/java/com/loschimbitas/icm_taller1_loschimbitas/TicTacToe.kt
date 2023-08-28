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
        val listaBotones = List(9) {
            findViewById<Button>(resources.getIdentifier("boton${it + 1}", "id", packageName))
        }

        var jugador = 1

        listaBotones.forEach { boton ->
            boton.setOnClickListener {
                jugador = juega(boton, jugador)
                boton.isEnabled = false
                verificador(listaBotones)
            }
        }

        findViewById<Button>(R.id.boton10).setOnClickListener {
            reiniciarBotones(listaBotones)
            jugador = 1
        }
    }

    private fun juega(button: Button, jugador: Int): Int {
        button.text = if (jugador == 1) "X" else "O"
        button.isEnabled = false
        return 3 - jugador // Cambiar del jugador 1 al 2 y viceversa
    }

    private fun verificador(listaBotones: List<Button>) {
        val ganadorEnLinea = listOf(
            0..2, 3..5, 6..8,     // Verificaciones verticales
            0..6 step 3, 1..7 step 3, 2..8 step 3,  // Verificaciones horizontales
            0..8 step 4, 2..6 step 2  // Verificaciones diagonales
        )

        for (i in ganadorEnLinea)
            if (hayGanador(i.map { listaBotones[it] })) {
                apagarBotones(listaBotones)
                return
            }
    }

    private fun hayGanador(listaBotones: List<Button>): Boolean {
        val jugador = listaBotones[0].text
        if (jugador == "")
            return false

        val coincide = listaBotones.subList(0, 3).all { it.text == jugador }
        if (coincide)
            cambiarColorBotonVerde(listaBotones)

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

    private fun apagarBotones(listaBotones: List<Button>) {
        // cambiamos el color de los botones a su color default y los habilitamos
        listaBotones.forEach { boton ->
            boton.isEnabled = false
        }
    }
}