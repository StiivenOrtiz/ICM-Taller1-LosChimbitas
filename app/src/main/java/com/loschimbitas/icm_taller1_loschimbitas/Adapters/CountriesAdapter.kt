package com.loschimbitas.icm_taller1_loschimbitas.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.loschimbitas.icm_taller1_loschimbitas.Modelo.Pais
import com.loschimbitas.icm_taller1_loschimbitas.R
import com.murgupluoglu.flagkit.FlagKit


class CountriesAdapter(private val mContext: Context, private val listaPaises: List<Pais>) :
    ArrayAdapter<Pais>(mContext, 0, listaPaises) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(mContext).inflate(R.layout.adapter_country, parent, false)

        val textViewNombrePais: TextView = layout.findViewById(R.id.textView1)
        val imageViewBanderaPais: ImageView = layout.findViewById(R.id.imageView1)

        textViewNombrePais.text = listaPaises[position].nombre_pais
        imageViewBanderaPais.setImageResource(
            FlagKit.getResId(
                context,
                listaPaises[position].sigla
            )
        )

        return layout
    }
}