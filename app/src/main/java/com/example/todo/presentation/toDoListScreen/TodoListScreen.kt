package com.example.todo.presentation.toDoListScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todo.R
import com.example.todo.components.SingleTodo
import com.example.todo.presentation.MainViewModel
import com.example.todo.presentation.navigation.AppScreens
import com.example.todo.ui.theme.poppins

@Composable
fun TodoListScreen(navController: NavController,viewModel: MainViewModel) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(AppScreens.AddToDoScreen.name) }){
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Add ToDo",
                    modifier = Modifier.size(25.dp))
            }
        }
    ) {
        MainContent(
            Modifier.padding(it),
            viewModel = viewModel)
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier,
                viewModel: MainViewModel) {
    val todos = viewModel.todo.collectAsState(initial = emptyList())
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row {
            Text(
                modifier = Modifier
                    .padding(
                        vertical = 19.dp,
                        horizontal = 40.dp
                    )
                    .weight(1f),
                text = "Today",
                fontFamily = poppins,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
            Icon(modifier = Modifier
                .align(CenterVertically)
                .padding(end = 12.dp),
                painter = painterResource(id = R.drawable.more),
                contentDescription = "More",
                tint = Color.Blue)
        }
        LazyColumn{
            items(todos.value){ toDo ->
                SingleTodo(toDo = toDo,onClick = {viewModel.deleteToDo(toDo)},viewModel = viewModel)
            }
        }
    }
}
