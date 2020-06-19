package com.ptit.example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ptit.example.R
import com.ptit.example.data.model.FoodDetail

class FoodAdapter : RecyclerView.Adapter<FoodViewHolder>() {

    private val foods = mutableListOf<FoodDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_food,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = foods.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) =
        holder.bind(foods[position])

    fun updateData(foods: List<FoodDetail>) {
        if (this.foods.isNotEmpty()) this.foods.clear()
        this.foods.addAll(foods)
        notifyDataSetChanged()
    }
}
