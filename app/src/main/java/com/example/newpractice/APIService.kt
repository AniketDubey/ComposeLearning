package com.example.newpractice

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface APIService {

    @GET("discover/movie")
    suspend fun fetchData(@Header("Authorization") token: String): Response<MovieResponse>
}