package com.clipandbooks.sample.sampleroom2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import com.clipandbooks.sample.sampleroom2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityMainBinding
    lateinit var mTodoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        mTodoViewModel.todoList.observe(this, {todoItems->updateTodoList(todoItems)})

        mBinding.add.setOnClickListener {

            val tempItem = mBinding.inputTodo.text.toString()
            if (tempItem.isNullOrEmpty()) {
                //Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
                Snackbar.make(mBinding.mainLayout, "값을 입력해 주세요", Snackbar.LENGTH_SHORT).show()
            } else {
                var todoItem = Todo()
                todoItem.title = mBinding.inputTodo.text.toString()
                mTodoViewModel.insert(todoItem)
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
        mBinding.inputTodo.setText("")
    }
}