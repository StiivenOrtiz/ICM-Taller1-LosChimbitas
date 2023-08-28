package com.loschimbitas.icm_taller1_loschimbitas

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExtraCountryInformation : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.extra_country_information)
        init()
    }

    @SuppressLint("SetJavaScriptEnabled", "SetTextI18n")
    fun init() {
        val pais = intent.getStringExtra("pais")
        val webView1: WebView = findViewById(R.id.webView1)
        val textView1: TextView = findViewById(R.id.textView1)

        webView1.webChromeClient = object : WebChromeClient() {}
        webView1.webViewClient = object : WebViewClient() {}
        webView1.settings.javaScriptEnabled = true

        if (pais != null) {
            pais.replace(" ", "_")
            textView1.text = pais
            webView1.loadUrl("https://en.wikipedia.org/wiki/$pais")
        } else
            textView1.text = "No se pudo cargar el país"
    }
}