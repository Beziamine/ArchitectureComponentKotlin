package com.example.architecturecomponentkotlin.di

import com.example.architecturecomponentkotlin.ui.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { HomeViewModel(get(), get())}

}