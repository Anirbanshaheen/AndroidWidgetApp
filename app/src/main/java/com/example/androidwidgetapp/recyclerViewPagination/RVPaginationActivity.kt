package com.example.androidwidgetapp.recyclerViewPagination

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidwidgetapp.R
import com.example.androidwidgetapp.databinding.ActivityRvpaginationBinding
import com.example.androidwidgetapp.databinding.ActivityRvviewTypeBinding

class RVPaginationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRvpaginationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvpaginationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {

    }
}