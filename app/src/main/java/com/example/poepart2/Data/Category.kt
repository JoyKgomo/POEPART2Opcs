package com.example.poepart2.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,
    val description: String,
    val amount: String
)
