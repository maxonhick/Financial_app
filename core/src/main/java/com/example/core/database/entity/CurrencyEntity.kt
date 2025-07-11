package com.example.core.database.entity

import androidx.room.*

@Entity(
    tableName = "currencies",
    indices = [Index(value = ["id"], unique = true)]
)
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "symbol") val symbol: String
)