package com.example.e_ticareturunakisi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.e_ticareturunakisi.databinding.CardCellBinding

class CardViewHolder (val cardCellBinding: CardCellBinding, val itemClickHandler: (Int)->Unit,
                      val ekleClickHandler: (Int)->Unit, val uyeGirisi:Boolean): RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindUrun(urun:Urun){
        cardCellBinding.ivUrunFotografi.setImageResource(urun.fotograf)
        cardCellBinding.tvMarka.text = urun.marka
        cardCellBinding.tvUrunAdi.text = urun.ad
        cardCellBinding.tvUrunFiyat.text = "₺"+ urun.fiyat.toString()
    }


    init{
        cardCellBinding.ivUrunFotografi.setOnClickListener {
            itemClickHandler(adapterPosition)
        }

        cardCellBinding.btnEkle.setOnClickListener{
            ekleClickHandler(adapterPosition)
        }

        if(!uyeGirisi){
            cardCellBinding.btnEkle.visibility = View.GONE

        }

    }




}