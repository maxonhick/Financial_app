package com.example.core.database.entity

import androidx.room.*

@Entity(
    tableName = "transactions",
    indices = [Index(value = ["id"], unique = true)]
)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo(name = "date") val date: Long,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "currency") val currency: String
)