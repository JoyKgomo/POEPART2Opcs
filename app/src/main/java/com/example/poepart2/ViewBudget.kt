package com.example.poepart2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.poepart2.Data.AppDatabase
import com.example.poepart2.Data.BudgetDao

class ViewBudget : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var budgetDao: BudgetDao
    private lateinit var budgetList: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewbudget)

        db = AppDatabase.getDatabase(this)
        budgetDao = db.BudgetDao()

         budgetList = findViewById(R.id.txtBudgetList)

        val close = findViewById<Button>(R.id.btnClose)
        close?.setOnClickListener{
            val intent = Intent( this,Analytics::class.java)
            startActivity(intent)
        }
    }

    private suspend fun updateBudgetList() {
        val budget = budgetDao.getEntireBudget()
        val list = budget.joinToString("\n") { "${it.id} Category: ${it.item} \t Minimum Goal: ${it.minGoal} \t Maximum Goal: ${it.maxGoal} " }
        runOnUiThread {
            budgetList.text = list
        }
    }
}