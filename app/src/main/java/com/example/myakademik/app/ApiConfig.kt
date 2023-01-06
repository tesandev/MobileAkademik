package com.example.myakademik.app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private const val BASE_URL = "http://10.0.2.2:8000/api/"

    val instance: ApiService by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
//    private val client: Retrofit
//        get() {
//            val gson = GsonBuilder()
//                .setLenient()
//                .create()
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//            val client: OkHttpClient = OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .connectTimeout(40, TimeUnit.SECONDS)
//                .readTimeout(40, TimeUnit.SECONDS)
//                .writeTimeout(40, TimeUnit.SECONDS)
//                .build()
//
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(client)
//                .build()
//        }
//
//    val instanceRetrofit: ApiService
//        get() = client.create(ApiService::class.java)
}