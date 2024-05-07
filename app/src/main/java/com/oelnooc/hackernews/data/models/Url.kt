package com.oelnooc.hackernews.data.models

data class Url(
    val matchLevel: String,
    val matchedWords: List<Any>,
    val value: String
)