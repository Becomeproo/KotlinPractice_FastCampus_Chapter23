package com.example.practicekotlin23.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practicekotlin23.data.entity.ToDoEntity
import com.example.practicekotlin23.data.local.db.dao.ToDoDao

@Database(
    entities = [ToDoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ToDoDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "ToDoDataBase.db"
    }

    abstract fun toDoDao(): ToDoDao
}