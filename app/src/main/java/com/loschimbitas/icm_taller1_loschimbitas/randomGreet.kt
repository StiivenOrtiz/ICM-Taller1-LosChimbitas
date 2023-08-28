package com.loschimbitas.icm_taller1_loschimbitas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class randomGreet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.random_greet)

        val idioma = intent.getStringExtra("idioma")
        if (idioma != null) {
            findViewById<TextView>(R.id.textView1).text =
                findViewById<TextView>(R.id.textView1).text.toString() + " " + idioma
            findViewById<TextView>(R.id.textView2).text = getString(
                resources.getIdentifier(
                    "random_greet_$idioma",
                    "string",
                    "com.loschimbitas.icm_taller1_loschimbitas"
                )
            )
        }
    }
}