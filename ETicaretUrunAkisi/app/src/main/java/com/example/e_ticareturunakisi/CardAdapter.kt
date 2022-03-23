package com.example.e_ticareturunakisi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_ticareturunakisi.databinding.CardCellBinding

class CardAdapter(private val urunler : List<Urun>, val itemCLickHandler:(Int)->Unit, val ekleClickHandler:(Int)->Unit,
                  val uyeGirisi:Boolean): RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from,parent,false)
        return CardViewHolder(binding, itemCLickHandler, ekleClickHandler, uyeGirisi)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindUrun(urunler[position])


    }

    override fun getItemCount(): Int {
        return urunler.size
    }
}