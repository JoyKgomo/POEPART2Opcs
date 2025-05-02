package com.example.poepart2

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.poepart2.Data.AppDatabase
import java.util.Calendar

class Expenses : AppCompatActivity() {

    private var selectedItem: String ?= null
    private lateinit var db: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_expenses)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        db = AppDatabase.getDatabase(this)

        val dateSelection = findViewById<Button>(R.id.btn_Date)
        val dateDisplay = findViewById<TextView>(R.id.txt_Date_Display)
        val cal = Calendar.getInstance()
        val myYear = cal.get(Calendar.YEAR)
        val myMonth = cal.get(Calendar.MONTH)
        val myDay = cal.get(Calendar.DAY_OF_MONTH)

        dateSelection.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                dateDisplay.text = "${dayOfMonth}/${month + 1}/$year"
            }, myYear, myMonth, myDay)
            datePickerDialog.show()
        }

        val spinner = findViewById<Spinner>(R.id.spinner2)
        val txtExpenseAmount = findViewById<EditText>(R.id.edtAmount)
        val txtExpenseDescription = findViewById<EditText>(R.id.edtDescription)

        val expenseAmount = txtExpenseAmount.text.toString()
        val expenseDescription = txtExpenseDescription.text.toString()

        val items = listOf(
            "Select Category",
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

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ){
                selectedItem = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}