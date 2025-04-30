package com.example.poepart2.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardDetails(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bankName:String,
    val accountHolderName:String,
    val cardNumber:Int,
    val accountType:String,
    val CVV:Int
)
