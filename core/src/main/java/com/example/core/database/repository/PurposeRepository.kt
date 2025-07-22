package com.example.core.database.repository

import com.example.core.database.dao.PurposeDao
import com.example.core.database.entity.PurposeEntity

class PurposeRepository(
    private val purposeDao: PurposeDao
): BaseRepository() {

    suspend fun insertPurpose(purpose: PurposeEntity): Result<Unit> {
        return safeCall {
            purposeDao.insert(purpose)
        }
    }

    suspend fun updatePurpose(purpose: PurposeEntity): Result<Unit> {
        return safeCall {
            purposeDao.update(purpose)
        }
    }

    suspend fun deletePurpose(purpose: PurposeEntity): Result<Unit> {
        return safeCall {
            purposeDao.delete(purpose)
        }
    }

    suspend fun getAllPurpose(): Result<List<PurposeEntity>> {
        return safeCall {
            purposeDao.getAllPurpose()
        }
    }

    suspend fun getPurposeById(purposeId: Int): Result<PurposeEntity> {
        return safeCall {
            purposeDao.getPurposeById(purposeId)
        }
    }
}