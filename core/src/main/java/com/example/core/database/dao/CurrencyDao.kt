package com.example.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.core.database.entity.CurrencyEntity

@Dao
interface CurrencyDao {
    @Insert
    suspend fun insert(currency: CurrencyEntity)

    @Update
    suspend fun update(currency: CurrencyEntity)

    @Delete
    suspend fun delete(currency: CurrencyEntity)

    @Query("SELECT * FROM currencies ORDER BY id DESC")
    suspend fun getAllCurrencies(): List<CurrencyEntity>

    @Query("SELECT * FROM currencies WHERE id = :currencyId")
    suspend fun getCurrencyById(currencyId: Int): CurrencyEntity
}