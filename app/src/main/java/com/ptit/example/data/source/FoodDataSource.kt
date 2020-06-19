package com.ptit.example.data.source

import com.ptit.example.data.model.response.FoodRandomResponse
import io.reactivex.Observable

interface FoodDataSource {

    interface Local

    interface Remote {
        fun getRandomFoods(): Observable<FoodRandomResponse>
    }
}
