package com.example.todo.data

import com.example.todo.domain.Repository
import com.example.todo.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(private val dao: TodoDao):Repository{
    override fun getAllToDos(): Flow<List<ToDo>> {
      return  dao.getAllToDos()
    }
    override suspend fun addToDo(toDo: ToDo) {
        dao.addToDo(toDo)
    }
    override suspend fun deleteToDo(toDo: ToDo) {
        dao.deleteToDo(toDo)
    }
}