package com.example.myakademik.app

import com.example.myakademik.model.ResponseLogin
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("nis") nis :String,
        @Field("password") password :String,
    ):Call<ResponseLogin>
}