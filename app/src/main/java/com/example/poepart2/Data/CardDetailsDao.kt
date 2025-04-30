package com.example.poepart2.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CardDetailsDao {
    @Insert
    suspend fun insert (CardDetails:CardDetails)

    @Query("SELECT * FROM CardDetails")
    suspend fun getAllUsers(): List<CardDetails>
}