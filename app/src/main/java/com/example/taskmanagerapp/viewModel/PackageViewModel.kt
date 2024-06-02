package com.example.taskmanagerapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagerapp.model.Package
import com.example.taskmanagerapp.repository.PackageRepository
import kotlinx.coroutines.launch

class PackageViewModel(private val repository: PackageRepository) : ViewModel() {

    val allPackages: LiveData<List<Package>> = repository.getAllPackages()

    fun insertPackage(pkg: Package) {
        viewModelScope.launch {
            repository.insertPackage(pkg)
        }
    }

    fun deletePackage(pkg: Package) {
        viewModelScope.launch {
            repository.deletePackage(pkg)
        }
    }
}