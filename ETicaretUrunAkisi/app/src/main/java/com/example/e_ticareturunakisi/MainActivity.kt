package com.example.e_ticareturunakisi

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.e_ticareturunakisi.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var imageButtonControl : Boolean =  true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()


        binding.btnGirisYap.setOnClickListener{

            var id:String = binding.ptTelefonNo.text.toString()
            var psw:String = binding.ptSifre.text.toString()

            if(id == "01111111111" && psw == "#e&it1m"){
                var intent = Intent(this,UrunlerActivity::class.java)
                intent.putExtra("ÜYE GİRİŞİ",true)
                startActivity(intent)
            }else{
                val adb = AlertDialog.Builder(this)
                adb.setTitle("Hatalı Giriş")
                adb.setMessage("Girdiğiniz kullanıcı adı veya şifre hatalı.")
                adb.setPositiveButton("Tamam") { dialog, which -> }
                adb.show()
            }
        }

        binding.btnUyeOlmadanGir.setOnClickListener {
            var intent = Intent(this,UrunlerActivity::class.java)
            intent.putExtra("ÜYE GİRİŞİ",false)
            startActivity(intent)

        }

        binding.btnEnableDisable.setOnClickListener {
            if(imageButtonControl){
                binding.ptSifre.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.btnEnableDisable.setImageResource(R.drawable.disable)
                imageButtonControl=false
            }else{
                binding.ptSifre.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.btnEnableDisable.setImageResource(R.drawable.enable)
                imageButtonControl=true
            }
        }

    }


}