package com.loschimbitas.icm_taller1_loschimbitas

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.loschimbitas.icm_taller1_loschimbitas.Adapters.CountriesAdapter
import com.loschimbitas.icm_taller1_loschimbitas.Modelo.Pais
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class countries : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countries)
        init()
    }

    fun init() {
        val list: ListView = findViewById(R.id.listView)

        val json = JSONObject(loadJSONFromAsset())
        val paisesJsonArray = json.getJSONArray("paises")

        var listaPaises: List<Pais> = listOf()


        for (i in 0 until paisesJsonArray.length()) {
            val pais = paisesJsonArray.getJSONObject(i)
            val mPais = Pais(
                pais.getString("capital"),
                pais.getString("nombre_pais"),
                pais.getString("nombre_pais_int"),
                pais.getString("sigla")
            )
            listaPaises = listaPaises + mPais
        }

        val adapter = CountriesAdapter(this, listaPaises)

        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            val intent: Intent = Intent(this, showCountry::class.java)
            intent.putExtra("pais", listaPaises[position])
            startActivity(intent)
        }
    }

    fun loadJSONFromAsset(): String? {
        val json: String?
        try {
            val inputStream: InputStream = assets.open("paises (1).json")
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