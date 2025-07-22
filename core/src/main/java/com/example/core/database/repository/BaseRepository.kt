package com.example.core.database.repository

abstract class BaseRepository {
    suspend fun <T> safeCall(block: suspend () -> T): Result<T> {
        return try {
            Result.Success(block())
        } catch (e: Exception) {
            Result.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }
}

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
}
