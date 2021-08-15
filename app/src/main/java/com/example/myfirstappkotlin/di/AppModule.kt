package com.example.myfirstappkotlin.di

import com.example.myfirstappkotlin.api.ApiService
import com.example.myfirstappkotlin.helper.utils.Constants.BASE_URL
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Abdurashidov Shahzod on 15/08/21 21:58.
 * company QQBank
 * shahzod9933@gmail.com
 */


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provide
    // Binds
    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


}