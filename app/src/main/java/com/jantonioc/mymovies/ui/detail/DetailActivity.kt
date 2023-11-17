package com.jantonioc.mymovies.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.jantonioc.mymovies.R
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

            if (movie != null) {
                appendinfo(R.string.original_languaje, movie.original_language)
                appendinfo(R.string.original_title, movie.original_title)
                appendinfo(R.string.release_date, movie.release_date)
                appendinfo(R.string.popularity, movie.popularity.toString())
                appendinfo(R.string.vote_average, movie.vote_average.toString())


            }

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

    private fun SpannableStringBuilder.appendinfo(stringRes: Int, value: String)
    {
        bold {
            append(getString(stringRes))
            append(": ")
        }
        appendLine(value)
    }

}