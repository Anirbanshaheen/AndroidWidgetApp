package com.example.androidwidgetapp.recyclerViewPagination.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.androidwidgetapp.recyclerViewPagination.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository): ViewModel() {
    val posts = repository.getPosts().flow.cachedIn(viewModelScope).also { Log.d("shaheen", "PagingData Flow created") }
    //val posts = repository.getPosts().flow.asLiveData().cachedIn(viewModelScope).also { Log.d("shaheen", "PagingData Flow created") }
}