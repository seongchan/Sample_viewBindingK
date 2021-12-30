package com.clipandbooks.sample.sampleroom1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.room.Room
import com.clipandbooks.sample.sampleroom1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val db  = Room.databaseBuilder(application, TodoDataBase::class.java,"userProfile").allowMainThreadQueries().build()
        updateTodoList(db.todoDao().getAll())

        mBinding.add.setOnClickListener {

            val tempItem = mBinding.inputTodo.text.toString()
            if (tempItem.isNullOrEmpty()) {
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                var todoItem = Todo()
                todoItem.title = mBinding.inputTodo.text.toString()
                db.todoDao().insert(todoItem)
                updateTodoList(db.todoDao().getAll())
                mBinding.inputTodo.setText("")
            }
        }
    }

    private fun updateTodoList(todoList:List<Todo>) {
        var todoListText = ""
        for (todoItem in todoList) {
            todoListText += """
                
                ${todoItem.title}
            """.trimIndent()
        }
        mBinding.result.text = todoListText
    }
}