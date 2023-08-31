package com.loschimbitas.icm_taller1_loschimbitas // Declarar el paquete

import android.annotation.SuppressLint // Importar anotación para permitir JavaScript
import android.os.Bundle // Importar clase para manejar el Bundle
import android.webkit.WebView // Importar clase para manejar el WebView
import android.webkit.WebViewClient // Importar clase para manejar el WebView en la misma app
import android.widget.TextView // Importar clase para manejar el TextView
import androidx.appcompat.app.AppCompatActivity // Importar clase para manejar la actividad

class ExtraCountryInformation :
    AppCompatActivity() { // Actividad para mostrar información adicional de un país
    @SuppressLint("SetJavaScriptEnabled") // Permitir JavaScript
    override fun onCreate(savedInstanceState: Bundle?) { // Al crear la actividad
        super.onCreate(savedInstanceState) // Ejecutar el constructor de la clase padre
        setContentView(R.layout.extra_country_information) // Establecer el layout
        init() // Inicializar
    }

    @SuppressLint(
        "SetJavaScriptEnabled",
        "SetTextI18n"
    ) // Permitir JavaScript y texto internacional
    fun init() { // Inicializar
        val pais = intent.getStringExtra("pais") // Obtener el país
        val webView1: WebView = findViewById(R.id.webView1) // Obtener el WebView
        val textView1: TextView = findViewById(R.id.textView1) // Obtener el TextView

        webView1.webViewClient = object : WebViewClient() {} // Ejecutar en la misma app
        webView1.settings.javaScriptEnabled = true // Permitir JavaScript

        if (pais != null) { // Si el país no es nulo
            pais.replace(" ", "_") // Reemplazar espacios por guiones bajos
            textView1.text = pais // Mostrar el nombre del país
            webView1.loadUrl("https://en.wikipedia.org/wiki/$pais") // Cargar la página de Wikipedia
        } else // Si el país es nulo
            textView1.text = "No se pudo cargar el país" // Mostrar un mensaje de error
    }
}