package com.loschimbitas.icm_taller1_loschimbitas.Modelo // Declarar el paquete

import java.io.Serializable // Importar clase para manejar el Serializable

class Pais( // Clase para manejar el modelo de país
    var capital: String,
    var nombre_pais: String,
    var nombre_pais_int: String,
    var sigla: String // Constructor de la clase
) : Serializable // Modelo de país