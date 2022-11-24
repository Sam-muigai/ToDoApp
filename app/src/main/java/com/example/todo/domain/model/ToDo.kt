package com.example.todo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toDo_tbl")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val todoId:Int? = null,
    val todoItem:String,
//    val isChecked:Boolean = false
)