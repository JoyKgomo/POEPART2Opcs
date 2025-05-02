package com.example.poepart2.Data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ExpensesDao {
    @Insert
    suspend fun insert (expenses: Expenses)


}