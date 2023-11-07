package com.jantonioc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
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
        title = movie?.title
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w780/${movie?.backdrop_path}")
            .into(binding.backdrop)

        binding.summary.text = movie?.overview
        bindDetailInfo(binding.detailinfo,movie)

    }

    private fun bindDetailInfo(detailinfo: TextView, movie: Movie?) {
        detailinfo.text = buildSpannedString {
            bold { append("Original language: ")}
            appendLine(movie?.original_language)

            bold { append("Original Tittle: ")}
            appendLine(movie?.original_title)

            bold { append("Release Date: ")}
            appendLine(movie?.release_date)

            bold { append("Popularity: ")}
            appendLine(movie?.popularity.toString())

            bold { append("Vote Average: ")}
            appendLine(movie?.vote_average.toString())
        }
    }
}