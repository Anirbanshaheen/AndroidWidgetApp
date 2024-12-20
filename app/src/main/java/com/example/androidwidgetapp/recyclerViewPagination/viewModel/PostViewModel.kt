package com.example.androidwidgetapp.recyclerViewPagination.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.androidwidgetapp.recyclerViewPagination.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        _isLoading.value = false
    }

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    val posts = repository.getPosts().flow.cachedIn(viewModelScope).also { Log.d("shaheen", "PagingData Flow created") }

    // todo using live data
    //val posts = repository.getPosts().flow.asLiveData().cachedIn(viewModelScope).also { Log.d("shaheen", "PagingData Flow created") }
}