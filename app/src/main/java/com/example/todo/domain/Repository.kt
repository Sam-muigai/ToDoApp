package com.example.todo.domain

import com.example.todo.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

interface Repository{

    fun getAllToDos():Flow<List<ToDo>>

    suspend fun addToDo(toDo: ToDo)

    suspend fun deleteToDo(toDo: ToDo)

}

