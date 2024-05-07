package com.oelnooc.hackernews.data.api.repositories

import com.oelnooc.hackernews.data.api.client.HackerNewsClient
import com.oelnooc.hackernews.data.api.repositories.dao.HitDao
import com.oelnooc.hackernews.data.models.HitEntity

class HackerNewsRepository(private val hitDao: HitDao) {

    private val hackerNewsApiService = HackerNewsClient.getInstance()

    suspend fun getHits(query: String): List<HitEntity> {
        val response = hackerNewsApiService.getPosts(query)
        if (response.isSuccessful) {
            response.body()?.hits?.let { hits ->
                for (hit in hits) {
                    hitDao.insert(HitEntity.fromHit(hit))
                }
            }
        }
        return hitDao.getAll()
    }

    suspend fun deleteHit(hit: HitEntity) {
        hitDao.delete(hit)
    }
}