package com.example.myakademik.siswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myakademik.ListGambarActivity
import com.example.myakademik.LoginActivity
import com.example.myakademik.R
import com.example.myakademik.helper.SharedPref
import kotlinx.android.synthetic.main.activity_home_siswa.*

class HomeSiswaActivity : AppCompatActivity() {

    private lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_siswa)

        s = SharedPref(this)

        if(!s.getStatus()){
            logout()
        }

        tv_nama.text = "Selamat datang, "+s.getString(s.name)
        NIS.text = s.getString(s.nis)
        Role.text = s.getString(s.role_name)
        Glide.with(applicationContext)
            .load("https://cdn.pixabay.com/user/2018/06/27/01-23-02-27_250x250.jpg")
            .into(gambar)

        btn_logout.setOnClickListener {
            logout()
        }

        btn_list.setOnClickListener {
            startActivity(Intent(this@HomeSiswaActivity,ListGambarActivity::class.java))
        }
    }

    fun logout(){
        s.setStatusLogin(false)
        val intent = Intent(this@HomeSiswaActivity, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}