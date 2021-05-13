package com.example.newsnotes.domain.usecase

import com.example.newsnotes.data.model.APIResponse
import com.example.newsnotes.data.util.Resource
import com.example.newsnotes.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }

}