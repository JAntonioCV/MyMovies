package com.jantonioc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.jantonioc.mymovies.databinding.ActivityMainBinding
import com.jantonioc.mymovies.model.Movie
import com.jantonioc.mymovies.model.MovieDbClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val moviesAdapter = MoviesAdapter(emptyList()) { movie ->
            Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_SHORT).show()
        }

        binding.recycler.adapter = moviesAdapter

        lifecycleScope.launch {
            val apiKey = getString(R.string.api_Key)
            val popularMovies = MovieDbClient.service.listPopularMovie(apiKey)
                moviesAdapter.movies = popularMovies.results
                moviesAdapter.notifyDataSetChanged()
        }
    }
}