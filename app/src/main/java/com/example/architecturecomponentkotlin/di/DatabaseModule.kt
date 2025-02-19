package com.example.architecturecomponentkotlin.di

import androidx.room.Room
import com.example.architecturecomponentkotlin.R
import com.example.architecturecomponentkotlin.api.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        ).build()
    }

    single {
        get<AppDatabase>().modelDAO()
    }
}