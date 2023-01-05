package com.example.myakademik.pengurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myakademik.LoginActivity
import com.example.myakademik.R
import com.example.myakademik.helper.SharedPref
import kotlinx.android.synthetic.main.activity_home_siswa.*

class HomePetugasActivity : AppCompatActivity() {

    private lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_petugas)

        s = SharedPref(this)

        if(!s.getStatus()){
            logout()
        }

        tv_nama.text = "Selamat datang, "+s.getString(s.name)
        NIS.text = s.getString(s.nis)
        Role.text = s.getString(s.role_name)

        btn_logout.setOnClickListener {
            logout()
        }
    }

    fun logout(){
        s.setStatusLogin(false)
        startActivity(Intent(this@HomePetugasActivity, LoginActivity::class.java))
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}