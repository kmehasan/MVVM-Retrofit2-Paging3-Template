package io.github.kmehasan.mvvmretrofit2paging3template.network

import ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    var baseUrl = "https://rickandmortyapi.com/api/"

    private var gson: Gson = GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd hh:mm:ss.S").create()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    val API_SERVICE: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}