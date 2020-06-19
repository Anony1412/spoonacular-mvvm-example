package com.ptit.example.data.source.remote.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance private constructor() {

    companion object {

        private const val BASE_URL = "https://api.spoonacular.com/"
        private var instance: Retrofit? = null

        fun getInstance(): Retrofit =
            instance ?: Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().also { instance = it }
    }
}
