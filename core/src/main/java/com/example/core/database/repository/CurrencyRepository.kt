package com.example.core.database.repository

import com.example.core.database.dao.CurrencyDao
import com.example.core.database.entity.CurrencyEntity

class CurrencyRepository(
    private val currencyDao: CurrencyDao
): BaseRepository() {

    suspend fun insertCurrency(currency: CurrencyEntity): Result<Unit> {
        return safeCall{
            currencyDao.insert(currency)
        }
    }

    suspend fun updateCurrency(currency: CurrencyEntity): Result<Unit> {
        return safeCall {
            currencyDao.update(currency)
        }
    }

    suspend fun deleteCurrency(currency: CurrencyEntity): Result<Unit> {
        return safeCall {
            currencyDao.delete(currency)
        }
    }

    suspend fun getAllCurrencies(): Result<List<CurrencyEntity>> {
        return safeCall {
            currencyDao.getAllCurrencies()
        }
    }

    suspend fun getCurrencyById(currencyId: Int): Result<CurrencyEntity> {
        return safeCall {
            currencyDao.getCurrencyById(currencyId)
        }
    }
}