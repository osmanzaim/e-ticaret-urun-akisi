package com.example.e_ticareturunakisi

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_ticareturunakisi.databinding.ActivityUrunlerBinding


class UrunlerActivity : AppCompatActivity() {
    lateinit var binding: ActivityUrunlerBinding
    lateinit var adap : ElemanAdapter
    var kategoriler : ArrayList<Kategori> = arrayListOf(Kategori("Tişört"),Kategori("Gömlek"),Kategori("Kazak"),Kategori("Takım Elbise"),Kategori("Ceket"),Kategori("Yelek"))

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


        kategoriFilter(secilenKategori)

        binding.imageView.setOnClickListener {
            urunList.clear()
            sepetTutar = 0f
            index=0
            finish()
        }

    }

    private fun urunleriDoldur() {
        urunList.clear()
        val urun1 = Urun(R.drawable.foto1,"Erkek Tişört", 170.5f,"Mavi", Kategori("Tişört"),detay = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus finibus semper interdum. Suspendisse ac augue posuere, mollis urna accumsan, bibendum sapien. Maecenas rhoncus ante ligula, ullamcorper convallis lectus blandit nec.")
        urunList.add(urun1)
        val urun2 = Urun(R.drawable.foto2,"Erkek Tişört", 275.5f,"Jack&Jones", Kategori("Tişört"),detay = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus finibus semper interdum. Suspendisse ac augue posuere, mollis urna accumsan, bibendum sapien. Maecenas rhoncus ante ligula, ullamcorper convallis lectus blandit nec.")
        urunList.add(urun2)
        val urun3 = Urun(R.drawable.foto3,"Erkek Tişört", 25.1f,"Mavi",Kategori("Tişört"),detay = "Sed ut quam et ante vulputate maximus malesuada ut erat. Proin ut arcu ex. Aliquam ut interdum nisl. Vestibulum sagittis, dui ac ornare ultricies, leo libero ullamcorper mi")
        urunList.add(urun3)
        val urun4 = Urun(R.drawable.foto4,"Erkek Tişört", 200.5f,"Mavi",Kategori("Tişört"),detay = "Aliquam venenatis orci rhoncus tempus scelerisque. Vivamus et pretium quam. Donec non nulla vel eros placerat pulvinar. Nulla id odio at nulla maximus sagittis at hendrerit turpis.")
        urunList.add(urun4)
        val urun5 = Urun(R.drawable.foto5,"Erkek Tişört", 130.5f,"Koton",Kategori("Tişört"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun5)
        val urun6 = Urun(R.drawable.foto6,"Erkek Gömlek", 199.5f,"LCW",Kategori("Gömlek"),detay = "Proin vel luctus ipsum, sollicitudin aliquam est. Duis ultricies pellentesque diam a dignissim. Donec dictum felis non nulla dapibus, nec pretium leo sollicitudin. ")
        urunList.add(urun6)
        val urun7 = Urun(R.drawable.foto7,"Erkek Gömlek", 42.5f,"H&M",Kategori("Gömlek"),detay = "Maecenas eleifend tortor a neque sollicitudin, nec lobortis velit rhoncus. Praesent non lacus accumsan, luctus metus id, suscipit lectus. Ut ut felis justo.")
        urunList.add(urun7)
        val urun8 = Urun(R.drawable.foto8,"Erkek Gömlek", 400.5f,"Puma",Kategori("Gömlek"),detay = "Maecenas eleifend tortor a neque sollicitudin, nec lobortis velit rhoncus. Praesent non lacus accumsan, luctus metus id, suscipit lectus. Ut ut felis justo..")
        urunList.add(urun8)
        val urun9 = Urun(R.drawable.foto9,"Erkek Kazak", 999.5f,"Mavi",Kategori("Kazak"),detay = "ras sollicitudin neque odio, viverra porta libero hendrerit vel. Cras a diam massa. Pellentesque euismod dignissim ligula, eget vestibulum odio fermentum et.")
        urunList.add(urun9)
        val urun10 = Urun(R.drawable.foto10,"Erkek Kazak", 300.5f,"LCW",Kategori("Kazak"),detay = "Morbi sodales, diam et tincidunt consectetur, erat ipsum facilisis nibh, non varius velit arcu et nulla. Morbi porttitor, tellus quis pretium maximus.")
        urunList.add(urun10)
        val urun11 = Urun(R.drawable.foto11,"Erkek Kazak", 99.5f,"Jack&Jones",Kategori("Kazak"),detay = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam cursus consectetur lectus, id aliquam odio blandit eget. Praesent tempor libero libero. ")
        urunList.add(urun11)
        val urun12 = Urun(R.drawable.foto12,"Erkek Ceket", 100.5f,"Koton",Kategori("Ceket"),detay = "Donec quis elit sit amet nisl efficitur gravida nec quis mi. Nulla varius pulvinar bibendum.")
        urunList.add(urun12)
        val urun13 = Urun(R.drawable.foto13,"Erkek Ceket", 210.5f,"Mavi",Kategori("Ceket"),detay = "Ut pellentesque nisi elementum velit facilisis, sit amet tempor eros ultrices.")
        urunList.add(urun13)
        val urun14 = Urun(R.drawable.foto14,"Takım Elbise", 3599.5f,"Altınyıldız",Kategori("Takım Elbise"),detay = "Ut pellentesque nisi elementum velit facilisis, sit amet tempor eros ultrices.")
        urunList.add(urun14)
        val urun15 = Urun(R.drawable.foto15,"Erkek Yelek", 300.5f,"Koton",Kategori("Yelek"),detay = "Uonec quis elit sit amet nisl efficitur gravida nec quis mi. Nulla varius pulvinar bibendum.")
        urunList.add(urun15)
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

        var kategorilenmisList = arrayListOf<Urun>()
        for(item in urunList){
            if(item.kategori.kategoriAdi == sKategori){
                kategorilenmisList.add(item)
            }
        }

        urunList.clear()
        urunList.addAll(kategorilenmisList)
        binding.rvUrunler.adapter!!.notifyDataSetChanged()

    }

}