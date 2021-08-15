package com.example.myfirstappkotlin.repository

import com.example.myfirstappkotlin.api.ApiService
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 15/08/21 22:14.
 * company QQBank
 * shahzod9933@gmail.com
 */

class TvShowRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getTvShows() = apiService.getTvShows()
}