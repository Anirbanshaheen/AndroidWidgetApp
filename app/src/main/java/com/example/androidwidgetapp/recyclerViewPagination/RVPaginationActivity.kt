package com.example.androidwidgetapp.recyclerViewPagination

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidwidgetapp.databinding.ActivityRvpaginationBinding
import com.example.androidwidgetapp.recyclerViewPagination.viewModel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RVPaginationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRvpaginationBinding
    private val viewModel: PostViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvpaginationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observer()
    }

    private fun init() {
        postAdapter = PostAdapter()
        binding.rV.layoutManager = LinearLayoutManager(this)
        binding.rV.adapter = postAdapter
    }

    private fun observer(){
        lifecycleScope.launch {
            viewModel.posts.collectLatest { pagingData ->
                Log.d("shaheen", "Submitting PagingData to Adapter $pagingData")
                postAdapter.submitData(pagingData)
            }

//            viewModel.posts.observe(this@RVPaginationActivity, ) { pagingData ->
//                Log.d("shaheen", "Submitting PagingData to Adapter")
//                postAdapter.submitData(lifecycle, pagingData)
//            }
        }
    }
}