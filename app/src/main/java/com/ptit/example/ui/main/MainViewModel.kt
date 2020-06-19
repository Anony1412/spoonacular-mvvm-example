package com.ptit.example.ui.main

import androidx.lifecycle.ViewModel
import com.ptit.example.data.repository.FoodRemoteRepository

class MainViewModel(private val foodRemoteRepository: FoodRemoteRepository): ViewModel() {

    fun getRandomFoods() = foodRemoteRepository.getRandomFoods()
}
