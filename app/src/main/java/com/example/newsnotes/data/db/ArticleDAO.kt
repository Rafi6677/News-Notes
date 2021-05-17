package com.example.newsnotes.data.db

import androidx.room.*
import com.example.newsnotes.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("SELECT * FROM articles")
    fun getSavedArticles(): Flow<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}