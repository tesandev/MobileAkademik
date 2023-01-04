package com.example.myakademik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myakademik.helper.SharedPref
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    private lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        s = SharedPref(this)

        if(!s.getStatus()){
            startActivity(Intent(this@Home, MainActivity::class.java))
            finish()
        }

        tv_nama.text = s.getString(s.name)
        NIS.text = s.getString(s.nis)
        Role.text = s.getString(s.role_name)

        btn_logout.setOnClickListener {
            logout()
        }
    }

    fun logout(){
        s.setStatusLogin(false)
        startActivity(Intent(this@Home, MainActivity::class.java))
        finish()
    }
}