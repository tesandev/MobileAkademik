package com.example.myakademik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myakademik.app.ApiConfigListGambar
import com.example.myakademik.model.ResponseListGambar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListGambarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_gambar)

        ApiConfigListGambar.instanceRetrofit.listGambar().enqueue(object : Callback<List<ResponseListGambar>>{
            override fun onResponse(
                call: Call<List<ResponseListGambar>>,
                response: Response<List<ResponseListGambar>>
            ) {
                var respon = response.body()
            }

            override fun onFailure(call: Call<List<ResponseListGambar>>, t: Throwable) {
                Toast.makeText(applicationContext,t.message.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }
}