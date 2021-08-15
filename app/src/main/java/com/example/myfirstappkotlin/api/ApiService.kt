package com.example.myfirstappkotlin.api

import com.example.myfirstappkotlin.helper.utils.Constants.END_POINT
import com.example.myfirstappkotlin.models.TvShowResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by Abdurashidov Shahzod on 15/08/21 21:41.
 * company QQBank
 * shahzod9933@gmail.com
 */
interface ApiService {
    @GET(END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>

}