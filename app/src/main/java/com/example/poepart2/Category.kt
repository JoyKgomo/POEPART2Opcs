package com.example.poepart2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Spinner

class Category : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)



        val spinner = findViewById<Spinner>(R.id.spinner)

        val items = listOf("Select option", "Option 1", "Option 2", "Option 3")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            items
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        val txtMin = findViewById<EditText>(R.id.edtMinGoal)
        val txtMax = findViewById<EditText>(R.id.edtMaxGoal)

        val minGoal = txtMin.text.toString()
        val  maxGoal = txtMax.text.toString()

        if (minGoal>maxGoal){
           txtMax.error="Your maximum goal should be greater than your min goal"
            txtMax.text.clear()
        }

    }
}