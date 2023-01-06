package com.example.myakademik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myakademik.adapter.RoleAdapter
import com.example.myakademik.app.ApiConfig
import com.example.myakademik.app.ApiConfigListPhoto
import com.example.myakademik.model.ResponseListRole
import com.example.myakademik.model.ResponsePhotos
import com.example.myakademik.model.ResponsePixaby
import kotlinx.android.synthetic.main.activity_list_role.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListRole : AppCompatActivity() {

    private val list = ArrayList<ResponsePhotos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_role)

        rvListRole.setHasFixedSize(true)
        rvListRole.layoutManager = LinearLayoutManager(this)

        ApiConfigListPhoto.instance.photos().enqueue(object : Callback<ResponsePixaby>{
            override fun onResponse(
                call: Call<ResponsePixaby>,
                response: Response<ResponsePixaby>
            ) {
                val listResponse = response.body()?.items
                listResponse?.let { list.addAll(it) }
                val adp = RoleAdapter(list)
                rvListRole.adapter = adp
            }

            override fun onFailure(call: Call<ResponsePixaby>, t: Throwable) {
                Log.e("ERR",t.message.toString())            }

        })
    }
}