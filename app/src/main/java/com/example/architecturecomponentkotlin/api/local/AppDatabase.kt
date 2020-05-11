package com.example.architecturecomponentkotlin.api.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.architecturecomponentkotlin.api.local.dao.ModelDao
import com.example.architecturecomponentkotlin.api.local.entity.ModelEntity
import com.example.architecturecomponentkotlin.model.Model

@Database(entities = [Model::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun modelDAO(): ModelDao
}