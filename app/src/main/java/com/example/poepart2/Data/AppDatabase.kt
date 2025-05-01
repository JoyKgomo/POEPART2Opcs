package com.example.poepart2.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [User::class, Budget::class, CardDetails::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
    abstract fun BudgetDao(): BudgetDao
    abstract fun CardDetailsDao(): CardDetailsDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "part2_database"
                ).build().also { INSTANCE = it }
            }
        }
    }


}