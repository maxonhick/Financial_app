package com.example.core.database.repository

import com.example.core.database.dao.CategoryDao
import com.example.core.database.entity.CategoryEntity

class CategoryRepository(
    private val categoryDao: CategoryDao
) : BaseRepository() {

    suspend fun insertCategory(category: CategoryEntity): Result<Unit> {
        return safeCall {
            categoryDao.insert(category)
        }
    }

    suspend fun updateCategory(category: CategoryEntity): Result<Unit> {
        return safeCall {
            categoryDao.update(category)
        }
    }

    suspend fun deleteCategory(category: CategoryEntity): Result<Unit> {
        return safeCall {
            categoryDao.delete(category)
        }
    }

    suspend fun getAllCategory(): Result<List<CategoryEntity>> {
        return safeCall {
            categoryDao.getAllCategory()
        }
    }

    suspend fun getCategoryById(categoryId: Int): Result<CategoryEntity> {
        return safeCall {
            categoryDao.getCategoryById(categoryId)
        }
    }
}