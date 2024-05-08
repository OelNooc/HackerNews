package com.oelnooc.hackernews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oelnooc.hackernews.data.api.repositories.HackerNewsRepository
import com.oelnooc.hackernews.data.models.HitEntity
import kotlinx.coroutines.launch

class HomeScreenViewModel (private val repository: HackerNewsRepository) : ViewModel() {

    private val mutableHits = MutableLiveData<List<HitEntity>>()
    val hits: LiveData<List<HitEntity>> get() = mutableHits

    fun getData() {
        viewModelScope.launch {
            try {
                mutableHits.value = repository.getHits(QUERY)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        const val QUERY = "mobile"
    }
}