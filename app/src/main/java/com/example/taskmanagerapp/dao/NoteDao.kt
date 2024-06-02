package com.example.taskmanagerapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taskmanagerapp.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM notes WHERE packageId = :packageId")
    suspend fun getNotesByPackageId(packageId: Int): List<Note>
}
