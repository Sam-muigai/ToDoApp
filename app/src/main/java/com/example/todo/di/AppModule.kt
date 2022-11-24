package com.example.todo.di

import android.app.Application
import androidx.room.Room
import com.example.todo.data.TodoDatabase
import com.example.todo.data.TodoRepositoryImpl
import com.example.todo.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideTodoDatabase(app:Application):TodoDatabase =
        Room.databaseBuilder(app,
            TodoDatabase::class.java,
            "todo_db")
            .fallbackToDestructiveMigration().build()
    @Singleton
    @Provides
    fun provideTodoRepository(db:TodoDatabase):Repository{
        return TodoRepositoryImpl(db.dao)
    }
}