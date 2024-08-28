package com.example.newpractice

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIService {

    @GET("discover/movie")
    suspend fun fetchData(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 3,
    ): Response<MovieResponse>
}