package com.loschimbitas.icm_taller1_loschimbitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class countries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countries)
        val list: ListView = findViewById(R.id.listView)

        val json = JSONObject(loadJSONFromAsset())
        val paisesJsonArray = json.getJSONArray("paises")

        var nombreCapitales = arrayOfNulls<String>(paisesJsonArray.length());

        for (i in 0 until paisesJsonArray.length()) {
            val pais = paisesJsonArray.getJSONObject(i)
            nombreCapitales[i] = pais.getString("nombre_pais") + " - " + pais.getString("capital")
        }

        val adapter1 = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, nombreCapitales)

        list.adapter = adapter1

    }

    fun loadJSONFromAsset(): String? {
        val json: String?
        try {
            val inputStream: InputStream = getAssets().open("paises (1).json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}