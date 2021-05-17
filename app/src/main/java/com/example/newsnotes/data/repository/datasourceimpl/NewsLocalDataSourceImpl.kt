package com.example.newsnotes.data.repository.datasourceimpl

import com.example.newsnotes.data.db.ArticleDAO
import com.example.newsnotes.data.model.Article
import com.example.newsnotes.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> = articleDAO.getSavedArticles()

}