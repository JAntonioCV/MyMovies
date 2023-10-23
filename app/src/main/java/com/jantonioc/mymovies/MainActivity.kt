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
                Movie("Titulo 1","URL 1"),
                Movie("Titulo 2","URL 2"),
                Movie("Titulo 3","URL 3"),
                Movie("Titulo 4","URL 4"),
                Movie("Titulo 5","URL 5"),
                Movie("Titulo 6","URL 6"),
                Movie("Titulo 7","URL 7"),
            )
        )

    }
}