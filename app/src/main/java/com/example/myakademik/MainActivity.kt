package com.example.myakademik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myakademik.app.ApiConfig
import com.example.myakademik.helper.SharedPref
import com.example.myakademik.model.ResponseLogin
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var statusLogin = false
    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        if(s.getStatus()){
            startActivity(Intent(this@MainActivity, Home::class.java))
            finish()
        }

        btn_login.setOnClickListener {
            login()
        }
    }

    fun login(){
        if(edt_nis.text.isEmpty()){
            edt_nis.error = "Kolom NIS tidak boleh kosong"
            edt_nis.requestFocus()
            return
        }else if (edt_password.text.isEmpty()){
            edt_password.error = "Kolom Password tidak boleh kosong"
            edt_password.requestFocus()
            return
        }
        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.login(edt_nis.text.toString(),edt_password.text.toString())
            .enqueue(object : Callback<ResponseLogin>{

                override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                    var respon = response.body()!!
                    pb.visibility = View.GONE
                    if(respon.StatusCode == 1){
                        s.setStatusLogin(true);
                        s.setString(s.name, respon.Data.name)
                        s.setString(s.id_user, respon.Data.id_user)
                        s.setString(s.id_role, respon.Data.id_role)
                        s.setString(s.role_name, respon.Data.role_name)
                        s.setString(s.nis, respon.Data.nis)
                        val intent = Intent(this@MainActivity, Home::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        Toast.makeText(applicationContext,respon.Message+", Selamat datang "+respon.Data.role_name+","+respon.Data.name,Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext,"Error "+respon.Message,Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                    pb.visibility = View.GONE
                    Toast.makeText(applicationContext,t.message.toString(),Toast.LENGTH_SHORT).show()
                }

            })
    }
}