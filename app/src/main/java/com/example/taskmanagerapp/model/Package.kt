package com.example.taskmanagerapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "packages")
data class Package(
    @PrimaryKey(autoGenerate = true) val packageId: Int = 0,
    @ColumnInfo(name = "packageName") val packageName: String
)
