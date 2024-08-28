package com.example.newpractice

import androidx.paging.Pager
import androidx.paging.PagingConfig

class MovieRepo {
    fun getMovies(): Pager<Int, Result> {
        return Pager(
            config = PagingConfig(pageSize = 100),
            pagingSourceFactory = { PagingSource() }
        )
    }
}