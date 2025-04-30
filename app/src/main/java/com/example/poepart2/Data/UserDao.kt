package com.example.poepart2.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {
    @Insert
    suspend fun insert (User:User)

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM User WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): User?
}