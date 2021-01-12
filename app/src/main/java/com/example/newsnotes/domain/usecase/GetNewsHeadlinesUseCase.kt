package com.example.newsnotes.domain.usecase

import com.example.newsnotes.data.model.APIResponse
import com.example.newsnotes.data.util.Resource
import com.example.newsnotes.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines()
    }

}