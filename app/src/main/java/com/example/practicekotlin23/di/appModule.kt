package com.example.practicekotlin23.di

import android.content.Context
import androidx.room.Room
import com.example.practicekotlin23.data.local.db.ToDoDatabase
import com.example.practicekotlin23.data.repository.DefaultToDoRepository
import com.example.practicekotlin23.data.repository.ToDoRepository
import com.example.practicekotlin23.domain.todo.*
import com.example.practicekotlin23.domain.todo.DeleteAllToDoItemUseCase
import com.example.practicekotlin23.domain.todo.GetToDoListUseCase
import com.example.practicekotlin23.domain.todo.InsertToDoListUseCase
import com.example.practicekotlin23.presentation.detail.DetailMode
import com.example.practicekotlin23.presentation.detail.DetailViewModel
import com.example.practicekotlin23.presentation.list.ListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {

    single { Dispatchers.Main }
    single { Dispatchers.IO }

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
    single<ToDoRepository> { DefaultToDoRepository(get(), get()) }

    single { provideDB(androidApplication()) }
    single { provideToDoDao(get())}
}

internal fun provideDB(context: Context): ToDoDatabase =
    Room.databaseBuilder(context, ToDoDatabase::class.java, ToDoDatabase.DB_NAME).build()

internal fun provideToDoDao(database: ToDoDatabase) = database.toDoDao()