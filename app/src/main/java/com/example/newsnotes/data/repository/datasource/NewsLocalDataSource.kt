package com.example.newsnotes.data.repository.datasource

import com.example.newsnotes.data.model.Article

interface NewsLocalDataSource {

    suspend fun saveArticleToDB(article: Article)

}