package com.example.nutritiontracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foods: List<Food>): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodNameText: TextView
        val caloriesText: TextView

        init {
            foodNameText = itemView.findViewById(R.id.foodText)
            caloriesText = itemView.findViewById(R.id.caloriesText)
        }
    }

    override fun getItemCount(): Int = foods.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nutrition_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foods[position]

        holder.foodNameText.text = food.name
        holder.caloriesText.text = food.calories
    }

}
