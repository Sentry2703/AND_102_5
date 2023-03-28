package com.example.nutritiontracker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.icu.text.DateIntervalFormat.FormattedDateInterval
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var foods : MutableList<Food>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodRv = findViewById<RecyclerView>(R.id.NutritionRv)
        foods = ArrayList()
        var adapter = FoodAdapter(foods)
        foodRv.adapter = adapter
        foodRv.layoutManager = LinearLayoutManager(this)

        val addButton = findViewById<Button>(R.id.addFoodButton)
        val context: Context = this
        addButton.setOnClickListener {
            val intent = Intent(context, AddFoodScreen::class.java)
            startActivityForResult(intent, 0)
            onActivityResult(0, 0, intent)
            adapter = FoodAdapter(foods)
            foodRv.adapter = adapter
            foodRv.layoutManager = LinearLayoutManager(this)
        }




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val food = data?.getParcelableExtra<Food>("Food")
            if (food != null) {
                FoodAdder.addFood(foods, food)
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }



}