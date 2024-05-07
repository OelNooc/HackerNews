package com.oelnooc.hackernews.data.api.client

import com.oelnooc.hackernews.data.api.interfaces.HackerNewsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HackerNewsClient {

    companion object{
        private const val base_url = "https://hn.algolia.com/api/v1/"

        fun getInstance() : HackerNewsApiService
        {
            val retrofit = Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(HackerNewsApiService::class.java)
        }
    }
}