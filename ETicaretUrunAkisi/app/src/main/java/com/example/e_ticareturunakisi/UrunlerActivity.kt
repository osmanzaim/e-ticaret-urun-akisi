package com.example.e_ticareturunakisi

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_ticareturunakisi.databinding.ActivityUrunlerBinding
import kotlin.properties.Delegates

class UrunlerActivity : AppCompatActivity() {
    lateinit var binding: ActivityUrunlerBinding
    lateinit var adap : ElemanAdapter
    var kategoriler : ArrayList<Kategori> = arrayListOf(Kategori("Koşu Ayakkabısı"),Kategori("Günlük Giyim"),Kategori("Crossfit Ayakkabısı"),Kategori("Krampon"),Kategori("Basket Ayakkabısı"),Kategori("Blucher"),Kategori("Terlik"),Kategori("Sandalet"))
    var uyeGirisi:Boolean?= null
    var secilenKategori : String = kategoriler[0].kategoriAdi

    companion object{
        var index: Int = 0
        var sepetTutar: Float = 0f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUrunlerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()

        uyeGirisi = intent.getBooleanExtra("ÜYE GİRİŞİ",false)

        if(!(uyeGirisi as Boolean)){
            binding.imgSepet.visibility = View.GONE
            binding.tvToplamTutar.visibility = View.GONE
        }

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvKategoriler.layoutManager = llm
        adap = ElemanAdapter(this, kategoriler, ::clickItem)
        binding.rvKategoriler.adapter = adap

        binding.rvUrunler.apply {
            layoutManager= GridLayoutManager(applicationContext,4)
            adapter = CardAdapter(urunList, ::cardViewClickHandler, ::btnSepeteEkleClickHandler, uyeGirisi!!)
        }

        if(uyeGirisi != null){
        }

        kategoriFilter(secilenKategori)

        binding.imageView.setOnClickListener {
            urunList.clear()
            sepetTutar = 0f
            index=0
            finish()
        }


    }

    private fun urunleriDoldur() {
        val urun1 = Urun(R.drawable.ua1,"Project Rock", 370.5f,"Under Armour", Kategori("Koşu Ayakkabısı"),detay = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus finibus semper interdum. Suspendisse ac augue posuere, mollis urna accumsan, bibendum sapien. Maecenas rhoncus ante ligula, ullamcorper convallis lectus blandit nec.")
        urunList.add(urun1)
        val urun2 = Urun(R.drawable.ua2,"Black Fives", 543.5f,"Puma",Kategori("Günlük Giyim"),detay = "Maecenas malesuada quis lacus sit amet tincidunt. In eu nisi imperdiet, malesuada nisi in, aliquet mauris.")
        urunList.add(urun2)
        val urun3 = Urun(R.drawable.ua3,"Air Force", 300.1f,"Nike",Kategori("Koşu Ayakkabısı"),detay = "Sed ut quam et ante vulputate maximus malesuada ut erat. Proin ut arcu ex. Aliquam ut interdum nisl. Vestibulum sagittis, dui ac ornare ultricies, leo libero ullamcorper mi")
        urunList.add(urun3)
        val urun4 = Urun(R.drawable.ua4,"Blazer", 231.5f,"Nike",Kategori("Koşu Ayakkabısı"),detay = "Aliquam venenatis orci rhoncus tempus scelerisque. Vivamus et pretium quam. Donec non nulla vel eros placerat pulvinar. Nulla id odio at nulla maximus sagittis at hendrerit turpis.")
        urunList.add(urun4)
        val urun5 = Urun(R.drawable.ua5,"UA Surge", 795.5f,"Under Armour",Kategori("Günlük Giyim"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun5)
        val urun6 = Urun(R.drawable.ayakkabi2,"Air Jordan", 995.5f,"Nike",Kategori("Koşu Ayakkabısı"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun6)
        val urun7 = Urun(R.drawable.ayakkabi3,"Superstar", 100.5f,"adidas",Kategori("Günlük Giyim"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun7)
        val urun8 = Urun(R.drawable.ayakkabi4,"SUEDE", 221.5f,"Puma",Kategori("Koşu Ayakkabısı"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun8)
        val urun9 = Urun(R.drawable.ayakkabi5,"Authentic", 1199.5f,"Vans",Kategori("Günlük Giyim"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun9)
        val urun10 = Urun(R.drawable.ayakkabi6,"Legacy Lifter", 699.5f,"Reebok",Kategori("Crossfit Ayakkabısı"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun10)
        val urun11 = Urun(R.drawable.ayakkabi1,"Nike Krampon", 129.5f,"Nike",Kategori("Krampon"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun11)

    }


    fun clickItem(position:Int) {
        index = position
        secilenKategori = kategoriler[position].kategoriAdi
        kategoriFilter(secilenKategori)
        binding.rvKategoriler.adapter = adap
    }

    fun cardViewClickHandler(position: Int) {
            var intent = Intent(this, DetayActivity::class.java)
            intent.putExtra("ÜYE GİRİŞİ",uyeGirisi)
            intent.putExtra("SEÇİLEN ÜRÜN",urunList[position])
            resultLauncher.launch(intent)
    }
    fun btnSepeteEkleClickHandler(position: Int) {
        sepetTutar += urunList[position].fiyat
        var tutarText = "₺$sepetTutar"
        binding.tvToplamTutar.setText(tutarText)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            binding.tvToplamTutar.setText("₺$sepetTutar")
        }
    }

    override fun onBackPressed() {
        urunList.clear()
        sepetTutar = 0f
        index=0
        finish()
    }

    fun kategoriFilter(sKategori : String) {
        urunleriDoldur()
        val kategorilenmisListe = urunList.filter { it.kategori.kategoriAdi == sKategori }
        urunList.clear()
        urunList.addAll(kategorilenmisListe)
        binding.rvUrunler.adapter!!.notifyDataSetChanged()
    }

}