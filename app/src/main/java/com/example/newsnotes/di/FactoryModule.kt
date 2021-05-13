package com.example.newsnotes.di

import android.app.Application
import com.example.newsnotes.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsnotes.domain.usecase.GetSearchedNewsUseCase
import com.example.newsnotes.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModel(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase
        )
    }

}