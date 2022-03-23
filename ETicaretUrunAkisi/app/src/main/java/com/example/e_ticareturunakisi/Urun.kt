package com.example.e_ticareturunakisi

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

var urunList = mutableListOf<Urun>()

@Parcelize
data class Urun(var fotograf: Int, var ad: String, var fiyat:Float, var marka: String, var kategori: Kategori, val id: Int?= urunList.size, var detay:String)
    :Parcelable {



}