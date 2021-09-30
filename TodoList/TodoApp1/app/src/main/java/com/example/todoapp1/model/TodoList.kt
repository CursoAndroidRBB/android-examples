package com.example.todoapp1.model

import com.example.todoapp1.model.Task

/**
 * Classe TodoList armazena uma lista de tarefas e fornece operações sobre ela
 *
 * @author Rodrigo Barros Bernardino
 * <a href="mailto:rberna.contato@gmail.com">rberna.contato@gmail.com</a>
 */
class TodoList {
    val taskList = mutableListOf<Task>()
}