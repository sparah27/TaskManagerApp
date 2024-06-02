package com.example.taskmanagerapp.repository

import androidx.lifecycle.LiveData
import com.example.taskmanagerapp.dao.PackageDao
import com.example.taskmanagerapp.model.Package

class PackageRepository(private val packageDao: PackageDao) {
    suspend fun insertPackage(pkg: Package) = packageDao.insertPackage(pkg)
    suspend fun updatePackage(pkg: Package) = packageDao.updatePackage(pkg)
    suspend fun deletePackage(pkg: Package) = packageDao.deletePackage(pkg)
    fun getAllPackages(): LiveData<List<Package>> = packageDao.getAllPackages()
}
