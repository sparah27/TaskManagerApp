package com.example.taskmanagerapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskmanagerapp.model.Package

@Dao
interface PackageDao {
    @Query("SELECT * FROM packages")
    fun getAllPackages(): LiveData<List<Package>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPackage(pkg: Package)

    @Update
    suspend fun updatePackage(pkg: Package)

    @Delete
    suspend fun deletePackage(pkg: Package)
}