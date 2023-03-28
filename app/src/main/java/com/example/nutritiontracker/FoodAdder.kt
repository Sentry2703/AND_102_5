package com.example.nutritiontracker

class FoodAdder {
    companion object{
        fun addFood(foods: MutableList<Food>,food: Food): MutableList<Food>{
            foods.add(food)
            return foods;
        }

    }
}