package com.example.taskmanagerapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskmanagerapp.dao.NoteDao
import com.example.taskmanagerapp.dao.PackageDao
import com.example.taskmanagerapp.model.Note
import com.example.taskmanagerapp.model.Package

@Database(entities = [Note::class, Package::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun packageDao(): PackageDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java,
                    "taskmanager.db")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
