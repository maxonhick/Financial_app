package com.example.core.database

import android.content.Context
import androidx.room.Room

object DatabaseModule {
    private lateinit var instance: AppDatabase

    fun getDatabase(context: Context): AppDatabase {
        if (!::instance.isInitialized) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "finance_db"
            ).fallbackToDestructiveMigration()
                .build()
        }
        return instance
    }
}