package com.test.solidtest.di.implementations

import com.test.solidtest.R
import com.test.solidtest.di.interfaces.IImageRepository
import com.test.solidtest.models.ImageLoaderSettings
import com.test.solidtest.models.ImageLoaderType

class LocalImageRepository : IImageRepository {
    override suspend fun getImage(): ImageLoaderSettings = ImageLoaderSettings(ImageLoaderType.RESOURCE, resId = R.drawable.img)
}