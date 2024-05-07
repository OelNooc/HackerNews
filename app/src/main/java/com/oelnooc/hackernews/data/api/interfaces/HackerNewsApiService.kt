package com.oelnooc.hackernews.data.api.interfaces

import com.oelnooc.hackernews.data.models.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HackerNewsApiService {

    @GET("search_by_date")
    fun getPosts(@Query("query") query: String): Response<Post>
}