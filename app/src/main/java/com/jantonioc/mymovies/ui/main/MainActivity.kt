package com.jantonioc.mymovies.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.jantonioc.mymovies.R
import com.jantonioc.mymovies.databinding.ActivityMainBinding
import com.jantonioc.mymovies.model.Movie
import com.jantonioc.mymovies.model.MovieDbClient
import com.jantonioc.mymovies.ui.detail.DetailActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    companion object {
        private const val DEFAULT_REGION = "US"
    }

    private val moviesAdapter = MoviesAdapter(emptyList()) { movie ->
        navigateTo(movie)
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val requestPermisionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        isGranted -> requestPopularMovies(isGranted)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        binding.recycler.adapter = moviesAdapter

        requestPermisionLauncher.launch(android.Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    @SuppressLint("MissingPermission")
    private fun requestPopularMovies(isLocationGranted: Boolean)
    {
        if(isLocationGranted)
        {
            fusedLocationClient.lastLocation.addOnCompleteListener{
                doRequestPopularMovies(getRegionFromLocation(it.result))
            }
        }else
        {
            doRequestPopularMovies(DEFAULT_REGION)
        }


    }

    private fun doRequestPopularMovies(region: String) {
        lifecycleScope.launch {
            val apiKey = getString(R.string.api_Key)
            val popularMovies = MovieDbClient.service.listPopularMovie(apiKey, region)
            moviesAdapter.movies = popularMovies.results
            moviesAdapter.notifyDataSetChanged()
        }
    }

    private fun getRegionFromLocation(location: Location?): String {

        if(location==null)
        {
            return  DEFAULT_REGION
        }

        val geocoder= Geocoder(this)
        val result = geocoder.getFromLocation(
            location.latitude,
            location.longitude,
            1
        )

        return result?.firstOrNull()?.countryCode ?: "US"
    }

    private fun navigateTo(movie: Movie) {
        val intent= Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE,movie)

        startActivity(intent)
    }
}