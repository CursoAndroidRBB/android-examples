package com.example.todoapp1.ex1Simples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.todoapp1.databinding.ActivityListViewSimplesBinding
import com.example.todoapp1.model.Task
import com.example.todoapp1.model.TodoList

class ListViewSimplesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListViewSimplesBinding

    private val todoListString = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewSimplesBinding.inflate(layoutInflater)

        setTitle("ListView Simples")

        todoListString.add("Lavar roupa")
        todoListString.add("Fazer relatório")
        todoListString.add("Compras supermercado")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoListString)
        binding.lstTarefasSimples.adapter = adapter

        setContentView(binding.root)
    }
}