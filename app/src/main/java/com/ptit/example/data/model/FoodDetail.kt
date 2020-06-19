package com.ptit.example.data.model

import com.google.gson.annotations.SerializedName

data class FoodDetail(

    @SerializedName("id")
    var id: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("image")
    var imageUrl: String? = ""
)
