package com.loschimbitas.icm_taller1_loschimbitas // Declarar el paquete

import android.os.Bundle // Importar clase para manejar el Bundle
import android.widget.Button // Importar clase para manejar el Button
import androidx.appcompat.app.AppCompatActivity // Importar clase para manejar la actividad

class TicTacToe : AppCompatActivity() { // Actividad para jugar Tic Tac Toe
    override fun onCreate(savedInstanceState: Bundle?) { // Al crear la actividad
        super.onCreate(savedInstanceState) // Ejecutar el constructor de la clase padre
        setContentView(R.layout.tic_tac_toe) // Establecer el layout
        iniciarJuego() // Iniciar el juego
    }

    private fun iniciarJuego() { // Iniciar el juego
        val listaBotones = List(9) { // Crear una lista de 9 botones
            findViewById<Button>( // Obtener el botón
                resources.getIdentifier( // Obtener el identificador del botón
                    "boton${it + 1}", // Nombre del botón
                    "id", // Tipo de identificador
                    packageName // Nombre del paquete
                )
            ) // Obtener el botón
        }

        var jugador = 1 // Inicializar el jugador

        listaBotones.forEach { boton -> // Para cada botón
            boton.setOnClickListener { // Al hacer clic en el botón
                jugador = juega(boton, jugador) // Jugar
                boton.isEnabled = false // Deshabilitar el botón
                verificador(listaBotones) // Verificar si hay un ganador
            }
        }

        findViewById<Button>(R.id.boton10).setOnClickListener { // Al hacer clic en el botón de reiniciar
            reiniciarBotones(listaBotones) // Reiniciar los botones
            jugador = 1 // Reiniciar el jugador
        }
    }

    private fun juega(button: Button, jugador: Int): Int { // Jugar
        button.text = if (jugador == 1) "X" else "O" // Establecer el texto del botón
        button.isEnabled = false // Deshabilitar el botón
        return 3 - jugador // Cambiar del jugador 1 al 2 y viceversa
    }

    private fun verificador(listaBotones: List<Button>) { // Verificar si hay un ganador
        val ganadorEnLinea = listOf( // Lista de listas de índices de botones para verificar
            0..2, 3..5, 6..8,     // Verificaciones verticales
            0..6 step 3, 1..7 step 3, 2..8 step 3,  // Verificaciones horizontales
            0..8 step 4, 2..6 step 2  // Verificaciones diagonales
        )

        for (i in ganadorEnLinea) // Para cada lista de índices de botones para verificar
            if (hayGanador(i.map { listaBotones[it] })) { // Si hay un ganador
                apagarBotones(listaBotones) // Apagar los botones
                return // Salir
            }
    }

    private fun hayGanador(listaBotones: List<Button>): Boolean { // Verificar si hay un ganador
        val jugador = listaBotones[0].text // Obtener el texto del primer botón
        if (jugador == "") // Si el texto es vacío
            return false // No hay ganador

        val coincide = listaBotones.subList(0, 3)
            .all { it.text == jugador } // Verificar si los primeros 3 botones coinciden
        if (coincide) // Si coinciden
            cambiarColorBotonVerde(listaBotones) // Cambiar el color de los botones a verde

        return coincide // Retornar si coinciden
    }


    private fun reiniciarBotones(listaBotones: List<Button>) { // Reiniciar los botones
        // cambiamos el color de los botones a su color default y los habilitamos
        listaBotones.forEach { boton -> // Para cada botón
            boton.isEnabled = true // Habilitar el botón
            boton.text = "" // Establecer el texto del botón
        }
        cambiarColorBotonDefault(listaBotones) // Cambiar el color de los botones a su color default
    }

    private fun cambiarColorBotonDefault(listaBotones: List<Button>) { // Cambiar el color de los botones a su color default
        listaBotones.forEach { boton -> // Para cada botón
            boton.backgroundTintList =
                resources.getColorStateList(R.color.blue_dark) // Cambiar el color del botón
        }
    }

    private fun cambiarColorBotonVerde(listaBotones: List<Button>) { // Cambiar el color de los botones a verde
        listaBotones.forEach { boton -> // Para cada botón
            boton.backgroundTintList =
                resources.getColorStateList(R.color.green_light) // Cambiar el color del botón
        }
    }

    private fun apagarBotones(listaBotones: List<Button>) { // Apagar los botones
        // cambiamos el color de los botones a su color default y los habilitamos
        listaBotones.forEach { boton -> // Para cada botón
            boton.isEnabled = false // Deshabilitar el botón
        }
    }
}