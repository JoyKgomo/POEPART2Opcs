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

    @Query("SELECT * FROM Expenses WHERE expenseDate BETWEEN :startDate AND :endDate")
    suspend fun getExpensesBetweenDates(startDate: java.util.Date, endDate: java.util.Date): List<Expenses>
}
