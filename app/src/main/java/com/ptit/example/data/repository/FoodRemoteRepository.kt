package com.ptit.example.data.repository

import com.ptit.example.data.model.response.FoodRandomResponse
import com.ptit.example.data.source.FoodDataSource
import io.reactivex.Observable

class FoodRemoteRepository private constructor(
    private val foodRemoteDataSource: FoodDataSource.Remote
) {

    fun getRandomFoods(): Observable<FoodRandomResponse> =
        foodRemoteDataSource.getRandomFoods()

    companion object {
        private var instance: FoodRemoteRepository? = null

        fun getInstance(foodRemoteDataSource: FoodDataSource.Remote): FoodRemoteRepository =
            instance ?: FoodRemoteRepository(foodRemoteDataSource).also { instance = it }
    }
}
