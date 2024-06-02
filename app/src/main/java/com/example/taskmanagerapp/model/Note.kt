package com.example.taskmanagerapp.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val noteId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo (name = "content") val content: String,
    @ColumnInfo (name = "packageId") val packageId: Int,
)