package com.test.solidtest.di.interfaces

import android.graphics.Bitmap
import com.test.solidtest.models.ImageLoaderSettings

interface IImageRepository {
    suspend fun getImage() : ImageLoaderSettings
    suspend fun addImageName(name:String) {}
}