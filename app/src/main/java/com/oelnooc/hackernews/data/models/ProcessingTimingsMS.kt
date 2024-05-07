package com.oelnooc.hackernews.data.models

import com.google.gson.annotations.SerializedName

data class ProcessingTimingsMS(
    @SerializedName("_request")
    val request: Request,
    val afterFetch: AfterFetch,
    val fetch: Fetch,
    val total: Int
)