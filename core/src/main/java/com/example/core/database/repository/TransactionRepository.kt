package com.example.core.database.repository

import com.example.core.database.dao.TransactionDao
import com.example.core.database.entity.TransactionEntity

class TransactionRepository(
    private val transactionDao: TransactionDao
) : BaseRepository() {

    suspend fun getAllTransactions(): Result<List<TransactionEntity>> {
        return safeCall {
            transactionDao.getAllTransactions()
        }
    }

    suspend fun getTransactionById(id: Int): Result<TransactionEntity?> {
        return safeCall {
            transactionDao.getTransactionById(id)
        }
    }

    suspend fun getTransactionsByCategoryId(categoryId: Int): Result<List<TransactionEntity>> {
        return safeCall {
            transactionDao.getTransactionsByCategory(categoryId)
        }
    }

    suspend fun insertTransaction(transaction: TransactionEntity): Result<Unit> {
        return safeCall {
            transactionDao.insert(transaction)
        }
    }

    suspend fun updateTransaction(transaction: TransactionEntity): Result<Unit> {
        return safeCall {
            transactionDao.update(transaction)
        }
    }

    suspend fun deleteTransaction(transaction: TransactionEntity): Result<Unit> {
        return safeCall {
            transactionDao.delete(transaction)
        }
    }
}
