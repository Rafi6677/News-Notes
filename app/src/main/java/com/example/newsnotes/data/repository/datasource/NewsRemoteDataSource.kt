package com.example.newsnotes.data.repository.datasource

import com.example.newsnotes.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(
        country: String,
        page: Int
    ): Response<APIResponse>

    suspend fun getSearchedTopHeadlines(
        country: String,
        searchedQuery: String,
        page: Int
    ): Response<APIResponse>

}