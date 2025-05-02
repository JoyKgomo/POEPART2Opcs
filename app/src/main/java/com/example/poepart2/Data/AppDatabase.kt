package com.example.poepart2.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database (entities = [User::class, Budget::class, CardDetails::class, Expenses::class], version = 2)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
    abstract fun BudgetDao(): BudgetDao
    abstract fun CardDetailsDao(): CardDetailsDao
    abstract fun ExpensesDao(): ExpensesDao

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