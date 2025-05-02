package com.example.poepart2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class landingpage : AppCompatActivity(){

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landingpage)



        val goToBudgetPage = findViewById<Button>(R.id.btnAddBudget)
        goToBudgetPage?.setOnClickListener{
            val intent = Intent( this,Budget::class.java)
            startActivity(intent)
        }

        val goToExpensePage = findViewById<Button>(R.id.btnAddExpense)
        goToExpensePage?.setOnClickListener{
            val intent = Intent( this,Expenses::class.java)
            startActivity(intent)
        }
}
}