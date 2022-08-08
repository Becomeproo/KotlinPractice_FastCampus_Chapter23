package com.example.practicekotlin23.domain.todo

import com.example.practicekotlin23.data.entity.ToDoEntity
import com.example.practicekotlin23.data.repository.ToDoRepository
import com.example.practicekotlin23.domain.UseCase

class DeleteToDoItemUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {

    suspend operator fun invoke(itemId: Long) {
        return toDoRepository.deleteToDoItem(itemId)
    }
}