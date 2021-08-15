package com.example.myfirstappkotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myfirstappkotlin.adapters.TvShowsAdapter
import com.example.myfirstappkotlin.databinding.ActivityMainBinding
import com.example.myfirstappkotlin.viewmodels.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tvShowsAdapter: TvShowsAdapter by lazy { TvShowsAdapter() }
    private val tvShowViewModel: TvShowViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRv()

    }

    private fun setupRv() {

        binding.rv.adapter = tvShowsAdapter
        binding.rv2.adapter = tvShowsAdapter
        binding.rv.setHasFixedSize(true)
        tvShowViewModel.response.observe(this, { listTvShows ->
            tvShowsAdapter.tvShowList = listTvShows
        })
    }
}
