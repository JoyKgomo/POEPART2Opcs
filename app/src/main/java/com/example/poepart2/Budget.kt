package com.example.poepart2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Spinner
import androidx.lifecycle.lifecycleScope
import com.example.poepart2.Data.AppDatabase
import com.example.poepart2.Data.BudgetDao
import kotlinx.coroutines.launch

class Budget : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var budgetDao: BudgetDao

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)

        db = AppDatabase.getDatabase(this)
        budgetDao = db.BudgetDao()

        val goToAnalytics = findViewById<Button>(R.id.btnAdd)


        goToAnalytics.setOnClickListener {

        val spinner = findViewById<Spinner>(R.id.spinner2)

        val items = listOf(
            "Select option",
            "Rent/Mortgage",
            "Transport",
            "Shopping",
            "Entertainment",
            "Groceries",
            "Toiletries",
            "Utilities",
            "Insurance"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            items
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        // Handle selected item
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()

                val txtMin = findViewById<EditText>(R.id.edtMinGoal)
                val txtMax = findViewById<EditText>(R.id.edtMaxGoal)

                val minGoal = txtMin.text.toString()
                val maxGoal = txtMax.text.toString()

                if (minGoal > maxGoal) {
                    txtMax.error = "Your maximum goal should be greater than your min goal"
                    txtMax.text.clear()
                }


                if (minGoal.isNotBlank() && maxGoal.isNotBlank() && selectedItem != "Select option") {
                    lifecycleScope.launch {
                        budgetDao.insert(
                            com.example.poepart2.Data.Budget(
                                item = selectedItem,
                                minGoal = minGoal,
                                maxGoal = maxGoal
                            )
                        )
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
            val intent = Intent( this,Analytics::class.java)
            startActivity(intent)
    }
}
}