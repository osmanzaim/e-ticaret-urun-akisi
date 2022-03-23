package com.example.e_ticareturunakisi

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ElemanViewHolder(itemView: View, var clickItem: (position:Int)->Unit) : RecyclerView.ViewHolder(itemView) {

    var tvKategori :TextView

    init{
        tvKategori = itemView.findViewById(R.id.tvKategori)

        itemView.setOnClickListener{
            clickItem(adapterPosition)

        }
    }


    fun setItems(kategori: Kategori, position: Int){
        tvKategori.setText(kategori.kategoriAdi)

        if(position == UrunlerActivity.index){
            tvKategori.setBackgroundColor(Color.parseColor("#9DD71C"))
            tvKategori.setTextColor(Color.parseColor("#FFFFFF"))
        }



    }

}