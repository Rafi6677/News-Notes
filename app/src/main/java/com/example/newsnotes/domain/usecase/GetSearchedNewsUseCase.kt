package com.example.newsnotes.domain.usecase

import com.example.newsnotes.data.model.APIResponse
import com.example.newsnotes.data.util.Resource
import com.example.newsnotes.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }

}