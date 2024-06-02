package com.example.taskmanagerapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskmanagerapp.R
import com.example.taskmanagerapp.ui.theme.CrystalTeal

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("folders") { FoldersScreen(navController) }
        composable("new_folder") { NewFolderScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("new_note") { NewNoteScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("new_note") },
                containerColor = CrystalTeal,
                content = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.pen_icon),
                        contentDescription = "Add Note",
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier.padding(16.dp)
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TopNavigationBar(navController)
                    Spacer(modifier = Modifier.height(8.dp))
                    SearchBar()
                }
            }
        }
    )
}

@Composable
fun TopNavigationBar(navController: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        IconButton(
            onClick = { navController.navigate("home") },
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.home_icon),
                contentDescription = "Home",
                modifier = Modifier.size(24.dp)
            )
        }

        Text(
            text = "Task Manager",
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.weight(1f)
        )

        IconButton(
            onClick = { navController.navigate("folders") },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.package_icon),
                contentDescription = "Folders",
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(
            onClick = { navController.navigate("settings") },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.settings_icon),
                contentDescription = "Settings",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun SearchBar() {
    val searchText = rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = searchText.value,
        onValueChange = { searchText.value = it },
        label = { Text("Search") },
        trailingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.search_icon),
                contentDescription = "Search Icon",
                modifier = Modifier.size(20.dp)
            )
        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}