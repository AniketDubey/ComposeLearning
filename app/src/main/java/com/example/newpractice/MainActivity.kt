package com.example.newpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<MovieViewModel>()
            /*LaunchedEffect(Unit) {
                viewModel.fetchData()
            }*/
            //val state = viewModel.movieList.collectAsState().value
            val state = viewModel.mData.collectAsLazyPagingItems()
            MovieList(state)
        }
    }
}

@Composable
fun MovieList(mList: LazyPagingItems<Result>) {
    LazyColumn {
        items(mList.itemCount) {
            mList[it]?.let { it1 -> Text(text = it1.title) }
        }
    }
}

