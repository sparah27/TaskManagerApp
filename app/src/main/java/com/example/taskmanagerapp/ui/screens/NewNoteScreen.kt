package com.example.taskmanagerapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.taskmanagerapp.R
import com.example.taskmanagerapp.ui.theme.CrystalTeal

@Composable
fun NewNoteScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TopNavigationBar(navController)
            Spacer(modifier = Modifier.height(8.dp))
            NewNote(navController)
        }
    }
}

@Composable
fun NewNote(navController: NavHostController) {
    val title = rememberSaveable { mutableStateOf("") }
    val note = rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = title.value,
        onValueChange = { title.value = it },
        label = { Text("Title") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    )
    OutlinedTextField(
        value = note.value,
        onValueChange = { note.value = it },
        label = { Text("Start typing...") },
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(vertical = 20.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        FloatingActionButton(
            onClick = { navController.navigate("home") },
            containerColor = CrystalTeal,
            content = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.check_icon),
                    contentDescription = "Save",
                    modifier = Modifier.size(24.dp)
                )
            },
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}
