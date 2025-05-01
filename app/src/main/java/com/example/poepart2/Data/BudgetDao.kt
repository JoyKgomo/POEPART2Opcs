package com.example.poepart2.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BudgetDao {
    @Insert
    suspend fun insert (Category:Budget)

    @Query("SELECT * FROM Budget")
    suspend fun getAllUsers(): List<Budget>
}