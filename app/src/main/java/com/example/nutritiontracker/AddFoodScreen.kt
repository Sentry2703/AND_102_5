package com.example.nutritiontracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddFoodScreen :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food_main)

        val addFoodButton = findViewById<Button>(R.id.addButton)
        val foodEdit = findViewById<EditText>(R.id.foodEdit)
        val caloriesEdit = findViewById<EditText>(R.id.caloriesEdit)
        var food: String?
        var calories: String?

        addFoodButton.setOnClickListener {
            food = foodEdit.text.toString()
            calories = caloriesEdit.text.toString()
            if (food.isNullOrEmpty() || calories.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter stuff before proceeding", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$food and $calories", Toast.LENGTH_SHORT).show()
                val foodA = Food(food!!, calories!!)

                val intent = Intent()
                intent.putExtra("Food", foodA)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

}

