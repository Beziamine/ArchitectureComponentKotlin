package com.example.architecturecomponentkotlin.api.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.architecturecomponentkotlin.model.Model

@Dao
interface ModelDao {

    @Query("SELECT * FROM model")
    fun all(): LiveData<List<Model>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(model: List<Model>)

}