package com.example.todo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.presentation.MainViewModel
import com.example.todo.presentation.addToDoScreen.AddToDoScreen
import com.example.todo.presentation.toDoListScreen.TodoListScreen

@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.ToDoListScreen.name){
        composable(AppScreens.ToDoListScreen.name){
            TodoListScreen(navController = navController,viewModel)
        }
        composable(AppScreens.AddToDoScreen.name){
            AddToDoScreen(navController = navController,viewModel)
        }
    }
}