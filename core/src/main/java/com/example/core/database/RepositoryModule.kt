package com.example.core.database

import com.example.core.database.repository.CategoryRepository
import com.example.core.database.repository.CurrencyRepository
import com.example.core.database.repository.TransactionRepository

class RepositoryModule(
    private val database: AppDatabase
) {

    fun provideTransactionRepository(): TransactionRepository {
        return TransactionRepository(database.transactionDao())
    }

    fun provideCategoryRepository(): CategoryRepository {
        return CategoryRepository(database.categoryDao())
    }

    fun provideCurrencyRepository(): CurrencyRepository {
        return CurrencyRepository(database.currencyDao())
    }
}
