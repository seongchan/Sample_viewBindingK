package com.clipandbooks.sample.sampleroom2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Insert
    fun insert(todo:Todo)

    @Update
    fun update(todo:Todo)

    @Delete
    fun delete(todo:Todo)

    @Query("Select * from Todo")
    fun getAll(): LiveData<List<Todo>>
}