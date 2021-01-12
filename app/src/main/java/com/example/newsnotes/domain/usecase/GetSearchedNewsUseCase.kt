package com.example.newsnotes.domain.usecase

import com.example.newsnotes.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}