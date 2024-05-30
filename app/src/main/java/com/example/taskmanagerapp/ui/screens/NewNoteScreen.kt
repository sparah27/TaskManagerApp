package com.example.taskmanagerapp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

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
            NewNote()
        }
    }
}

@Composable
fun NewNote() {
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
}