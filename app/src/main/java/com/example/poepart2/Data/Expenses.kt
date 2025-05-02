package com.example.poepart2.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Expenses(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val expenseDate: Date,
    val Categoryitem: String,
    val description: String,
    val amount: Double
)
