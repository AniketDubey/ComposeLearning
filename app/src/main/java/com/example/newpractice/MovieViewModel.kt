package com.example.newpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    private val repository = MovieRepo()

    private val _movieList = MutableStateFlow<List<Result>>(listOf())
    val movieList = _movieList.asStateFlow()

    fun fetchData(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.fetchData()
            if(response.isSuccessful){
                _movieList.emit(response.body()?.results!!)
            }
        }
    }
}