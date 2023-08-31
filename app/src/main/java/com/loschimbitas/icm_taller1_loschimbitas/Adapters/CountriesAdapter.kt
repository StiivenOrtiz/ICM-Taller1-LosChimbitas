package com.loschimbitas.icm_taller1_loschimbitas.Adapters // Declarar el paquete

import android.annotation.SuppressLint // Importar clase para manejar el SuppressLint
import android.content.Context // Importar clase para manejar el Context
import android.view.LayoutInflater // Importar clase para manejar el LayoutInflater
import android.view.View // Importar clase para manejar el View
import android.view.ViewGroup // Importar clase para manejar el ViewGroup
import android.widget.ArrayAdapter // Importar clase para manejar el ArrayAdapter
import android.widget.ImageView // Importar clase para manejar el ImageView
import android.widget.TextView // Importar clase para manejar el TextView
import com.bumptech.glide.Glide // Importar clase para manejar el Glide
import com.loschimbitas.icm_taller1_loschimbitas.Modelo.Pais // Importar clase para manejar el modelo de país
import com.loschimbitas.icm_taller1_loschimbitas.R // Importar clase para manejar el R
import java.util.Locale // Importar clase para manejar el Locale


class CountriesAdapter(private val mContext: Context, private val listaPaises: List<Pais>) :
    ArrayAdapter<Pais>(mContext, 0, listaPaises) { // Adaptador de países

    @SuppressLint("ViewHolder") // Suprimir advertencia
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View { // Al crear la vista
        val layout = LayoutInflater.from(mContext)
            .inflate(R.layout.adapter_country, parent, false) // Establecer el layout
        layout.findViewById<TextView>(R.id.textView1).text =
            listaPaises[position].nombre_pais // Establecer el nombre del país

        Glide.with(mContext)   // Cargar la bandera del país
            // https://flagcdn.com/w2560/$sigla.png  // URL de la bandera
            .load("https://flagcdn.com/w2560/${listaPaises[position].sigla.lowercase(Locale.ROOT)}.png") // URL de la bandera
            .into(layout.findViewById<ImageView>(R.id.imageView1)) // ImageView para mostrar la bandera

        return layout // Retornar la vista
    }
}