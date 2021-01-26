package com.example.newsnotes.data.repository.datasourceimpl

import com.example.newsnotes.data.api.NewsAPIService
import com.example.newsnotes.data.model.APIResponse
import com.example.newsnotes.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
): NewsRemoteDataSource {

    override suspend fun getTopHeadlines(
        country: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }

}