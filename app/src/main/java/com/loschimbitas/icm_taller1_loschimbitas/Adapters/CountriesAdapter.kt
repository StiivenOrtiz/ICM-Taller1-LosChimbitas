package com.loschimbitas.icm_taller1_loschimbitas.Adapters // Declarar el paquete

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.loschimbitas.icm_taller1_loschimbitas.Modelo.Pais
import com.loschimbitas.icm_taller1_loschimbitas.R


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
            .load("https://flagcdn.com/w2560/${listaPaises[position].sigla.lowercase()}.png") // URL de la bandera
            .into(layout.findViewById<ImageView>(R.id.imageView1)) // ImageView para mostrar la bandera

        return layout // Retornar la vista
    }
}