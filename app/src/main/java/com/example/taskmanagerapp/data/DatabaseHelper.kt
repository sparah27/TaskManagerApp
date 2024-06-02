package com.example.taskmanagerapp.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "TaskManager.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableNotes = """
            CREATE TABLE notes (
                titleid INTEGER PRIMARY KEY AUTOINCREMENT, 
                title TEXT, 
                packageid INTEGER,
                content TEXT
            )
        """.trimIndent()

        val createTablePackages = """
            CREATE TABLE packages (
                packageid INTEGER PRIMARY KEY AUTOINCREMENT, 
                packageTitle TEXT
            )
        """.trimIndent()

        db.execSQL(createTableNotes)
        db.execSQL(createTablePackages)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Notes")
        db.execSQL("DROP TABLE IF EXISTS Packages")
        onCreate(db)
    }
}
