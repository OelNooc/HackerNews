package com.oelnooc.hackernews.data.models

data class StoryTitle(
    val matchLevel: String,
    val matchedWords: List<Any>,
    val value: String
)