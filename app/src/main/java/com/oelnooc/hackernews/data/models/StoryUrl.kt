package com.oelnooc.hackernews.data.models

data class StoryUrl(
    val matchLevel: String,
    val matchedWords: List<Any>,
    val value: String
)