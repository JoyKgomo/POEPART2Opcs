package com.example.poepart2.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpensesDao {
    @Insert
    suspend fun insert (expenses: Expenses)

    @Query("SELECT * FROM Expenses")
    suspend fun getAllExpenses(): List<Expenses>
}