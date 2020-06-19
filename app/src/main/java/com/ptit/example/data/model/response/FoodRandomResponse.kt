package com.ptit.example.data.model.response

import com.google.gson.annotations.SerializedName
import com.ptit.example.data.model.FoodDetail

data class FoodRandomResponse(
    @SerializedName("recipes")
    val recipes: List<FoodDetail>
)
