package com.example.poepart2.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDao {
    @Insert
    suspend fun insert (Category:Category)

    @Query("SELECT * FROM Category")
    suspend fun getAllUsers(): List<Category>
}