package com.test.solidtest.di.implementations

import com.test.solidtest.di.interfaces.IImageRepository
import com.test.solidtest.helpers.API_KEY
import com.test.solidtest.models.ImageLoaderSettings
import com.test.solidtest.models.ImageLoaderType
import com.test.solidtest.retrofit.MoviesApiService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.lang.Exception

class WebServiceRepository : IImageRepository, KoinComponent {

    private val moviesApiService by inject<MoviesApiService>()

    override suspend fun getImage(): ImageLoaderSettings {
        val response = moviesApiService.getMovie(API_KEY,"IT")
        val image = response.body()?.Poster
        return if (image.isNullOrEmpty()) throw Exception("Empty image") else ImageLoaderSettings(ImageLoaderType.URL, image)
    }

}