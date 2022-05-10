package com.test.solidtest.di.implementations

import com.test.solidtest.di.interfaces.IImageRepository
import com.test.solidtest.models.ImageLoaderSettings
import com.test.solidtest.models.ImageLoaderType

class UrlImageRepository : IImageRepository {
    override suspend fun getImage(): ImageLoaderSettings = ImageLoaderSettings(ImageLoaderType.URL, url = "https://www.computerhope.com/jargon/a/android.png")
}