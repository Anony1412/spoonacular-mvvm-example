package com.ptit.example.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ptit.example.data.model.FoodDetail
import com.ptit.example.databinding.ItemFoodBinding

class FoodViewHolder(
    private val itemFoodBinding: ItemFoodBinding
): RecyclerView.ViewHolder(itemFoodBinding.root) {

    fun bind(food: FoodDetail) {
        itemFoodBinding.food = food
    }
}
