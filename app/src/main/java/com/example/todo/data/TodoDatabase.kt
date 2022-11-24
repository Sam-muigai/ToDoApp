package com.example.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.domain.model.ToDo

@Database(
    entities = [ToDo::class],
    version = 3)
abstract class TodoDatabase:RoomDatabase(){
    abstract val dao:TodoDao
}