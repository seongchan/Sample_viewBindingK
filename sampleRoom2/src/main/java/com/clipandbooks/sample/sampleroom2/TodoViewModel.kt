package com.clipandbooks.sample.sampleroom2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    var todoList: LiveData<List<Todo>>
    var todoDao:TodoDao

    init {
        val db  = Room.databaseBuilder(application, TodoDataBase::class.java,"userProfile").allowMainThreadQueries().build()
        todoDao = db.todoDao()
        todoList = todoDao.getAll()
    }


    fun insert(todoItem:Todo) {
        todoDao.insert(todoItem)
    }
}