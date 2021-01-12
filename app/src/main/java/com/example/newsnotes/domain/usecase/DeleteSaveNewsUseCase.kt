package com.example.newsnotes.domain.usecase

import com.example.newsnotes.data.model.Article
import com.example.newsnotes.domain.repository.NewsRepository

class DeleteSaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)

}