package com.example.todo.presentation.addToDoScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todo.domain.model.ToDo
import com.example.todo.presentation.MainViewModel

@Composable
fun AddToDoScreen(navController: NavController,
                  viewModel: MainViewModel) {
    Contents(viewModel = viewModel,navController = navController)
}

@Composable
fun Contents(modifier: Modifier = Modifier,
             viewModel: MainViewModel,
             navController: NavController) {
    val todo = remember { mutableStateOf<ToDo?>(null) }
    var text by remember {
        mutableStateOf("")
    }
    Column(modifier = modifier
        .fillMaxSize()
        .padding(9.dp)) {
        TextField(modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                          text = it
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Row (modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End){
            Button(onClick = {
                if (text.isNotEmpty()) {
                    viewModel.addToDo(ToDo(todoId = todo.value?.todoId, text))
                    navController.popBackStack()
                }
            }) {
                Text(text = "ADD")
            }
        }
    }
}