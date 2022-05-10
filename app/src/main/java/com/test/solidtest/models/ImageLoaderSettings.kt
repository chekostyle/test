package com.test.solidtest.models

import androidx.annotation.DrawableRes

data class ImageLoaderSettings (val type : ImageLoaderType, val url: String = "", @DrawableRes val resId: Int = 0)