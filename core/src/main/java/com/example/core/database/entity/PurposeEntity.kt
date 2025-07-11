package com.example.core.database.entity

import androidx.room.*

@Entity(
    tableName = "purposes",
    indices = [Index(value = ["id"], unique = true)]
)
data class PurposeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "finalAmount") val finalAmount: Int,
    @ColumnInfo(name = "progressAmount") val progressAmount: Int
)