package com.example.core.database.dao

import androidx.room.*
import com.example.core.database.entity.PurposeEntity

@Dao
interface PurposeDao {
    @Insert
    suspend fun insert(purpose: PurposeEntity)

    @Update
    suspend fun update(purpose: PurposeEntity)

    @Delete
    suspend fun delete(purpose: PurposeEntity)

    @Query("SELECT * FROM purposes ORDER BY id")
    suspend fun getAllPurpose(): List<PurposeEntity>

    @Query("SELECT * FROM purposes WHERE id = :purposeId")
    suspend fun getPurposeById(purposeId: Int): PurposeEntity
}