package com.oelnooc.hackernews.data.models

data class Author(
    val matchLevel: String,
    val matchedWords: List<Any>,
    val value: String
)