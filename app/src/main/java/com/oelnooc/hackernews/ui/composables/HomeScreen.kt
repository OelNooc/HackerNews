package com.oelnooc.hackernews.ui.composables

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.oelnooc.hackernews.data.api.repositories.HackerNewsDatabase
import com.oelnooc.hackernews.data.api.repositories.HackerNewsRepository
import com.oelnooc.hackernews.data.models.HitEntity
import com.oelnooc.hackernews.ui.themes.AppTheme
import com.oelnooc.hackernews.ui.viewmodel.HomeScreenViewModel
import com.oelnooc.hackernews.ui.viewmodel.HomeScreenViewModelFactory

class HomeScreen : ComponentActivity() {

    private lateinit var viewModel: HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = HackerNewsDatabase.getInstance(applicationContext)

        val repository = HackerNewsRepository(database.hitDao())

        val viewModelFactory = HomeScreenViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[HomeScreenViewModel::class.java]

        viewModel.getData()

        setContent {
            AppTheme.myAppTheme {
                val hits by viewModel.hits.observeAsState(initial = emptyList())
                Log.d("HomeScreen", "Hits count: ${hits.size}")
                HitList(hits)
            }
        }
    }

    @Composable
    fun HitList(hits: List<HitEntity>) {
        LazyColumn {
            if (hits.isEmpty()) {
                items(1) {
                    AppTheme.listItem(
                        title = "No item to list",
                        subtitle = "error on the api call"
                    )
                }
            } else{
                items(hits) { hit ->
                    AppTheme.listItem(
                        title = hit.title,
                        subtitle = "${hit.author} - ${hit.createdAt}"
                    )
                }
            }
        }
    }
}