package com.example.newpractice

import androidx.paging.PagingSource
import androidx.paging.PagingState

class PagingSource : PagingSource<Int, Result>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val page = params.key ?: 1
            //val pageSize = params.loadSize
            val token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4YzE4OTFjNDQ0NDc0ZGU5YTMxZDQ1ZmI5NWVlNWI4YyIsIm5iZiI6MTcyNDQzMDMxMC45MjI1MDQsInN1YiI6IjY2YjYxYmQyNmIzMmNlN2NlOTA3MTJmZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.qeqf2zqPmrJ_SqlOBuBElbziJ9Tmhz4ld94acTIcIaE"
            val response = RetrofitInstance.api.fetchData(token,page).body()?.results

            LoadResult.Page(
                data = response!!,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (page == 500) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}