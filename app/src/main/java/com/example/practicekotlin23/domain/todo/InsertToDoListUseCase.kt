package com.example.practicekotlin23.domain.todo

import com.example.practicekotlin23.data.entity.ToDoEntity
import com.example.practicekotlin23.data.repository.ToDoRepository
import com.example.practicekotlin23.domain.UseCase

internal class InsertToDoListUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {

    suspend operator fun invoke(toDoList: List<ToDoEntity>) {
        return toDoRepository.insertToDoList(toDoList)
    }
}