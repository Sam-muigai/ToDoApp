package com.example.todo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todo.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM toDo_tbl")
    fun getAllToDos():Flow<List<ToDo>>

    @Insert
    suspend fun addToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)
}