package com.example.todo.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.domain.Repository
import com.example.todo.domain.model.ToDo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    val todo = repository.getAllToDos()


    fun addToDo(toDo: ToDo){
        viewModelScope.launch {
            repository.addToDo(toDo = toDo)
        }
    }
    fun deleteToDo(toDo: ToDo){
        viewModelScope.launch {
            repository.deleteToDo(toDo = toDo)
        }
    }
//    fun onChecked(toDo: ToDo,
//                  isChecked:Boolean){
//        viewModelScope.launch {
//            repository.addToDo(toDo
//                .copy(isChecked = isChecked))
//        }
//    }

//    private var _data = mutableStateListOf<ToDo>()
//    val data = _data
//    private val dummyData = listOf<ToDo>()
//    fun addToDo(toDo: ToDo){
//        _data.add(toDo)
//    }
//    fun deleteToDo(toDo: ToDo){
//        _data.remove(toDo)
//    }
//    init {
//        _data.addAll(dummyData)
//    }
}