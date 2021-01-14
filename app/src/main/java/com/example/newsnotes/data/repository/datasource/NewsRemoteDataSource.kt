package com.example.newsnotes.data.repository.datasource

import com.example.newsnotes.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(): Response<APIResponse>

}