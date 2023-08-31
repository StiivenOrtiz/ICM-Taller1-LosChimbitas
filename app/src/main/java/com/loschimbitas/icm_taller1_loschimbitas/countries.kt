package com.loschimbitas.icm_taller1_loschimbitas // Declarar el paquete

import android.content.Intent // Importar clase para manejar el Intent
import android.os.Bundle // Importar clase para manejar el Bundle
import android.widget.ListView // Importar clase para manejar el ListView
import androidx.appcompat.app.AppCompatActivity // Importar clase para manejar la actividad
import com.loschimbitas.icm_taller1_loschimbitas.Adapters.CountriesAdapter // Importar clase para manejar el adaptador de países
import com.loschimbitas.icm_taller1_loschimbitas.Modelo.Pais // Importar clase para manejar el modelo de país
import org.json.JSONObject // Importar clase para manejar el JSONObject
import java.io.IOException // Importar clase para manejar el IOException
import java.io.InputStream // Importar clase para manejar el InputStream

class countries : AppCompatActivity() { // Actividad para mostrar la lista de países

    override fun onCreate(savedInstanceState: Bundle?) { // Al crear la actividad
        super.onCreate(savedInstanceState) // Ejecutar el constructor de la clase padre
        setContentView(R.layout.countries) // Establecer el layout
        init()
    }

    fun init() { // Inicializar la actividad
        val list: ListView = findViewById(R.id.listView) // ListView para mostrar la lista de países
        val paisesJsonArray =
            JSONObject(loadJSONFromAsset()).getJSONArray("paises") // Obtener el JSONArray de países
        var listaPaises: List<Pais> = listOf() // Lista de países

        for (i in 0 until paisesJsonArray.length()) { // Para cada país
            val pais = paisesJsonArray.getJSONObject(i) // Obtener el país
            val mPais = Pais( // Crear el país
                pais.getString("capital"),
                pais.getString("nombre_pais"),
                pais.getString("nombre_pais_int"),
                pais.getString("sigla")
            )
            listaPaises = listaPaises + mPais // Agregar el país a la lista
        }

        val adapter = CountriesAdapter(this, listaPaises) // Adaptador de países
        list.adapter = adapter // Establecer el adaptador de países

        list.setOnItemClickListener { parent, view, position, id -> // Al hacer clic en un país
            val intent: Intent = Intent(this, showCountry::class.java) // Crear el intent
            intent.putExtra("pais", listaPaises[position]) // Establecer el país
            startActivity(intent) // Iniciar la siguiente actividad
        }
    }

    fun loadJSONFromAsset(): String? { // Cargar el JSON de países
        val json: String? // JSON de países
        try {
            val inputStream: InputStream = assets.open("paises (1).json") // Abrir el JSON de países
            val size: Int = inputStream.available() // Tamaño del JSON de países
            val buffer = ByteArray(size) // Buffer para leer el JSON de países
            inputStream.read(buffer) // Leer el JSON de países
            inputStream.close() // Cerrar el JSON de países
            json = String(buffer, Charsets.UTF_8) // Establecer el JSON de países
        } catch (ex: IOException) { // Si no se pudo cargar el JSON de países
            ex.printStackTrace() // Mostrar mensaje de error
            return null // Retornar null
        }
        return json // Retornar el JSON de países
    }
}