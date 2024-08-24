package com.example.newpractice

import retrofit2.Response

class MovieRepo {
    suspend fun fetchData(): Response<MovieResponse>{
        val token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4YzE4OTFjNDQ0NDc0ZGU5YTMxZDQ1ZmI5NWVlNWI4YyIsIm5iZiI6MTcyNDQzMDMxMC45MjI1MDQsInN1YiI6IjY2YjYxYmQyNmIzMmNlN2NlOTA3MTJmZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.qeqf2zqPmrJ_SqlOBuBElbziJ9Tmhz4ld94acTIcIaE"
        return RetrofitInstance.api.fetchData(token)
    }
}