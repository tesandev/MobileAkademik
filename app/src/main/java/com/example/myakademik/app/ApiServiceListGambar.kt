package com.example.myakademik.app

import com.example.myakademik.model.ResponseListGambar
import com.example.myakademik.model.ResponseLogin
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServiceListGambar {

    @GET("?key=32616756-1db18867216e6ec3ae922e7d8&q=yellow+flowers&image_type=photo")
    fun listGambar(

    ):Call<List<ResponseListGambar>>
}