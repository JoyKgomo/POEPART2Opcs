package com.example.poepart2.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BudgetDao {
    @Insert
    suspend fun insert (budget:Budget)

    @Query("SELECT * FROM Budget")
    suspend fun getEntireBudget(): List<Budget>
}