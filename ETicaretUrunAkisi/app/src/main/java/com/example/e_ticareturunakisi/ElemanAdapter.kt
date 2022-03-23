package com.example.e_ticareturunakisi

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ElemanAdapter(var context: Context, var kategoriListesi: ArrayList<Kategori>,
                    var clickItem : (position: Int) -> Unit) : RecyclerView.Adapter<ElemanViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElemanViewHolder {

        val v = LayoutInflater.from(context).inflate(R.layout.rv_kategori_item,parent,false)
        return ElemanViewHolder(v,clickItem)
    }

    override fun onBindViewHolder(holder: ElemanViewHolder, position: Int) {
        holder.setItems(kategoriListesi[position], position)

    }

    override fun getItemCount(): Int {
        return kategoriListesi.size
    }
}