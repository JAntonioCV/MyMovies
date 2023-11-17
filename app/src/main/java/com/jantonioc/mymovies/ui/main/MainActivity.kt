package com.jantonioc.mymovies.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.jantonioc.mymovies.R
import com.jantonioc.mymovies.databinding.ActivityMainBinding
import com.jantonioc.mymovies.model.Movie
import com.jantonioc.mymovies.model.MovieDbClient
import com.jantonioc.mymovies.ui.detail.DetailActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val moviesAdapter = MoviesAdapter(emptyList()) { movie ->
            navigateTo(movie)
        }

        binding.recycler.adapter = moviesAdapter

        lifecycleScope.launch {
            val apiKey = getString(R.string.api_Key)
            val popularMovies = MovieDbClient.service.listPopularMovie(apiKey)
                moviesAdapter.movies = popularMovies.results
                moviesAdapter.notifyDataSetChanged()
        }
    }

    private fun navigateTo(movie: Movie) {
        val intent= Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE,movie)

        startActivity(intent)
    }
}