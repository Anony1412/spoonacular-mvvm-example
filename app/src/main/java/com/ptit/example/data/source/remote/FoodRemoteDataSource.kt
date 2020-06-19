package com.ptit.example.data.source.remote

import com.ptit.example.data.model.response.FoodRandomResponse
import com.ptit.example.data.source.FoodDataSource
import com.ptit.example.data.source.remote.api.ApiService
import io.reactivex.Observable

class FoodRemoteDataSource(private val apiService: ApiService) : FoodDataSource.Remote {

    override fun getRandomFoods(): Observable<FoodRandomResponse> = apiService.getRandomFoods()
}
