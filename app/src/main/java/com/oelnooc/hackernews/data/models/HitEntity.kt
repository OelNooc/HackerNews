package com.oelnooc.hackernews.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity
data class HitEntity(
    @PrimaryKey
    val objectID: String,
    val highlightResult: String,
    val tags: String,
    val author: String,
    val children: String,
    val commentText: String,
    val createdAt: String,
    val createdAtI: Int,
    val numComments: Int,
    val parentId: Int,
    val points: Int,
    val storyId: Int,
    val storyTitle :String,
    val storyURL :String?,
    val title :String,
    val updatedAt :String,
    val URL :String
) {
    companion object {
        fun fromHit(hit: Hit): HitEntity {
            return HitEntity(
                objectID = hit.objectID,
                highlightResult = Gson().toJson(hit.highlightResult),
                tags = Gson().toJson(hit.tags),
                author = hit.author,
                children = Gson().toJson(hit.children),
                commentText = hit.commentText,
                createdAt = hit.createdAt,
                createdAtI = hit.createdAtI,
                numComments = hit.numComments,
                parentId = hit.parentId,
                points = hit.points,
                storyId = hit.storyId,
                storyTitle = hit.storyTitle,
                storyURL = hit.storyUrl,
                title = hit.title,
                updatedAt = hit.updatedAt,
                URL = hit.url
            )
        }
    }
}
