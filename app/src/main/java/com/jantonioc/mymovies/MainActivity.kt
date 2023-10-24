package com.jantonioc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.jantonioc.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("Titulo 1", "https://loremflickr.com/320/240?lock=1"),
                Movie("Titulo 2", "https://loremflickr.com/320/240?lock=2"),
                Movie("Titulo 3", "https://loremflickr.com/320/240?lock=3"),
                Movie("Titulo 4", "https://loremflickr.com/320/240?lock=4"),
                Movie("Titulo 5", "https://loremflickr.com/320/240?lock=5"),
                Movie("Titulo 6", "https://loremflickr.com/320/240?lock=6"),
                Movie("Titulo 7", "https://loremflickr.com/320/240?lock=7"),
                Movie("Titulo 8", "https://loremflickr.com/320/240?lock=8"),
                Movie("Titulo 9", "https://loremflickr.com/320/240?lock=9"),
                Movie("Titulo 10", "https://loremflickr.com/320/240?lock=10"),
            )
        ) {movie ->
            Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_SHORT).show()
        }
//            //Evento Click
//                object : MovieClickListener{
//                    override fun onMovieClicked(movie: Movie) {
//                        Toast.makeText(this@MainActivity,movie.title,Toast.LENGTH_SHORT).show()
//                    }
//                }


    }
}