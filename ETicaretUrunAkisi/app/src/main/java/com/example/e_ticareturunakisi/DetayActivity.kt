package com.example.e_ticareturunakisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.e_ticareturunakisi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()
        var tutarText = "₺${UrunlerActivity.sepetTutar}"
        binding.tvToplamTutar.setText(tutarText)


        var girisYapiliMi : Boolean = intent.getBooleanExtra("ÜYE GİRİŞİ",false)
        var urun = intent.getParcelableExtra<Urun>("SEÇİLEN ÜRÜN")


        if(!girisYapiliMi){
            binding.btnEkle.visibility = View.GONE
            binding.tvToplamTutar.visibility = View.GONE
            binding.imgSepet.visibility = View.GONE
        }

        binding.ivUrunFoto.setImageResource(urun!!.fotograf)
        binding.tvUrunMarka.setText(urun.marka)
        binding.tvAciklama.setText(urun.detay)
        binding.tvUrunAd.setText(urun.ad)

        var urunFiyat = "₺"+ urun.fiyat.toString()
        binding.tvUrunDetayFiyat.setText(urunFiyat)


        binding.btnEkle.setOnClickListener{

            UrunlerActivity.sepetTutar += + urun.fiyat
            var toplamFiyat = "₺"+ UrunlerActivity.sepetTutar.toString()
            binding.tvToplamTutar.setText(toplamFiyat)
        }

        binding.imageView.setOnClickListener{
            intent = Intent()
            setResult(RESULT_OK, intent);
            finish();
        }

    }


    override fun onBackPressed() {

        intent = Intent()
        setResult(RESULT_OK, intent);
        finish();
    }
}