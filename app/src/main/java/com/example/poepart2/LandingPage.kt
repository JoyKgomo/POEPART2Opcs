package com.example.poepart2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.poepart2.Data.AppDatabase

import com.example.poepart2.Data.ExpensesDao

class LandingPage : AppCompatActivity(){

    private lateinit var db: AppDatabase
    private lateinit var ExpensesDao: ExpensesDao
    private lateinit var expenseList: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landingpage)

        db = AppDatabase.getDatabase(this)
        ExpensesDao = db.ExpensesDao()

        expenseList = findViewById(R.id.txtExpense)

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
    private suspend fun updateExpenseList() {
        val expense = ExpensesDao.getAllExpenses()
        val list = expense.joinToString("\n") { "${it.id} Category: ${it.categoryItem} \t Description: ${it.description} \t Amount: ${it.amount} " }
        runOnUiThread {
            expenseList.text = list
        }
    }
}