package com.example.practicekotlin23.di

import com.example.practicekotlin23.data.repository.TestToDoRepository
import com.example.practicekotlin23.data.repository.ToDoRepository
import com.example.practicekotlin23.domain.todo.*
import com.example.practicekotlin23.presentation.detail.DetailMode
import com.example.practicekotlin23.presentation.detail.DetailViewModel
import com.example.practicekotlin23.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    // ViewModel
    viewModel { ListViewModel(get(), get(), get()) }
    viewModel { (detailMode: DetailMode, id: Long) ->
        DetailViewModel(
            detailMode,
            id,
            get(),
            get(),
            get(),
            get()
        )
    }

    // UseCase
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { InsertToDoItemUseCase(get()) }
    factory { UpdateToDoListUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get()) }
    factory { DeleteToDoItemUseCase(get()) }

    // Repository
    single<ToDoRepository> { TestToDoRepository() }
}