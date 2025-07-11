package com.example.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core.database.dao.CategoryDao
import com.example.core.database.dao.CurrencyDao
import com.example.core.database.dao.PurposeDao
import com.example.core.database.dao.TransactionDao
import com.example.core.database.entity.CategoryEntity
import com.example.core.database.entity.CurrencyEntity
import com.example.core.database.entity.PurposeEntity
import com.example.core.database.entity.TransactionEntity

@Database(
    entities = [TransactionEntity::class, CategoryEntity::class, CurrencyEntity::class, PurposeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao
    abstract fun currencyDao(): CurrencyDao
    abstract fun purposeDao(): PurposeDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "finance_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}