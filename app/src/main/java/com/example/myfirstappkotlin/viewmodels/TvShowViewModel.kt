package com.example.myfirstappkotlin.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstappkotlin.models.TvShowItem
import com.example.myfirstappkotlin.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 15/08/21 22:24.
 * company QQBank
 * shahzod9933@gmail.com
 */
@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

    //LiveData
    private var _response = MutableLiveData<List<TvShowItem>>()
    val response: LiveData<List<TvShowItem>> get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
                Log.d("RESPONSE SUCCESSFUL:", "getAllTvShows:${response.body()}")
            } else {
                Log.d("RESPONSE ERROR:", "getAllTvShows:${response.message()}")
            }
        }
    }
}