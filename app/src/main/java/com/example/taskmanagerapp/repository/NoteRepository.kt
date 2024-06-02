package com.example.taskmanagerapp.repository

import androidx.lifecycle.LiveData
import com.example.taskmanagerapp.dao.NoteDao
import com.example.taskmanagerapp.model.Note

class NoteRepository(private val noteDao: NoteDao) {
    suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    suspend fun updateNote(note: Note) = noteDao.updateNote(note)
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    fun getAllNotes(): LiveData<List<Note>> = noteDao.getAllNotes()
}