package com.example.poepart2.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Budget(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val item: String,
    val minGoal: String,
    val maxGoal: String
)

