package com.test.solidtest.retrofit

import com.test.solidtest.models.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
    @GET("?")
    suspend fun getMovie(
        @Query("apikey") key: String,
        @Query("t") title: String?,
    ): Response<Movie>
}