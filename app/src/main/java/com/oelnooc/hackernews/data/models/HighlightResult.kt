package com.oelnooc.hackernews.data.models

import com.google.gson.annotations.SerializedName

data class HighlightResult(
    val author: Author,
    @SerializedName("comment_text")
    val commentText: CommentText,
    @SerializedName("story_title")
    val storyTitle: StoryTitle,
    @SerializedName("story_url")
    val storyUrl: StoryUrl?,
    val title: Title,
    val url: Url
)