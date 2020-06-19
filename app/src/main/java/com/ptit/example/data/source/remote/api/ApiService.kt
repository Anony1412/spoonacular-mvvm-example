package com.ptit.example.data.source.remote.api

import com.ptit.example.data.model.response.FoodRandomResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("/recipes/random?number=25&apiKey=f8e384a6df8945a6959e2ab32784cd0a")
    fun getRandomFoods(): Observable<FoodRandomResponse>
}
