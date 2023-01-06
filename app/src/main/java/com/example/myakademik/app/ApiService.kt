package com.example.myakademik.app

import com.example.myakademik.model.ResponseListRole
import com.example.myakademik.model.ResponseLogin
import com.example.myakademik.model.ResponsePhotos
import com.example.myakademik.model.ResponsePixaby
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("nis") nis :String,
        @Field("password") password :String,
    ):Call<ResponseLogin>

    @GET("listRoles")
    fun listRole():Call<ArrayList<ResponseListRole>>

    @GET("k_21d7cd2c")
    fun photos():Call<ResponsePixaby>
}