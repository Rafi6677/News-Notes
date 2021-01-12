package com.example.newsnotes.domain.usecase

import com.example.newsnotes.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
}