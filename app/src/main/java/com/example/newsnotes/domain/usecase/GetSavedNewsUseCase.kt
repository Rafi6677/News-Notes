package com.example.newsnotes.domain.usecase

import com.example.newsnotes.data.model.Article
import com.example.newsnotes.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> = newsRepository.getSavedNews()

}