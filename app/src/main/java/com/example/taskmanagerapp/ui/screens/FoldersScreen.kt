// FoldersScreen.kt
package com.example.taskmanagerapp.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.taskmanagerapp.R

@Composable
fun FoldersScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("new_folder") },
                containerColor = CrystalTeal,
                content = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.add_folder_icon),
                        contentDescription = "Add Folder",
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
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    )
}