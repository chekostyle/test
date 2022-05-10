package com.test.solidtest.helpers

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.test.solidtest.models.ImageLoaderSettings
import com.test.solidtest.models.ImageLoaderType
import java.lang.IllegalArgumentException

object ImageViewLoaderHelper {

    @JvmStatic
    @BindingAdapter("app:imageParam")
    fun ImageView.loadImage(imageParam:ImageLoaderSettings?) {
        if(imageParam != null){
            val picasso = Picasso.get()
            val creator = when(imageParam.type){
                ImageLoaderType.URL -> picasso.load(imageParam.url)
                ImageLoaderType.RESOURCE -> picasso.load(imageParam.resId)
            }
            creator.into(this)
        }
    }

}