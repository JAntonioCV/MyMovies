package com.jantonioc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.jantonioc.mymovies.databinding.ActivityDetailBinding
import com.jantonioc.mymovies.model.Movie

class DetailActivity : AppCompatActivity() {
    companion object{
       const val EXTRA_MOVIE = "DetailActivity:movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        binding.tittle.text = movie?.title
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w780/${movie?.backdrop_path}")
            .into(binding.backdrop)

    }
}