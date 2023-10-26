package com.jantonioc.mymovies.model

data class MovieDbResult(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,

    //@SerializedName("total_results")
    val total_results: Int
)