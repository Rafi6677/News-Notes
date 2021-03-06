package com.example.newsnotes.data.repository

import com.example.newsnotes.data.model.APIResponse
import com.example.newsnotes.data.model.Article
import com.example.newsnotes.data.repository.datasource.NewsLocalDataSource
import com.example.newsnotes.data.repository.datasource.NewsRemoteDataSource
import com.example.newsnotes.data.util.Resource
import com.example.newsnotes.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
): NewsRepository {

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }

        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(
            newsRemoteDataSource.getTopHeadlines(country, page)
        )
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(
            newsRemoteDataSource.getSearchedTopHeadlines(country, searchQuery, page)
        )
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticle(article)
    }

    override fun getSavedNews(): Flow<List<Article>> = newsLocalDataSource.getSavedArticles()

}