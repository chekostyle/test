package com.test.solidtest.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.solidtest.di.interfaces.IImageRepository
import com.test.solidtest.models.ImageLoaderSettings
import kotlinx.coroutines.launch

class MainActivityViewModel(imageRepository: IImageRepository) : ViewModel() {



    private val _imageParam = MutableLiveData<ImageLoaderSettings>(null)
    val imageParam : LiveData<ImageLoaderSettings>
        get() = _imageParam

    init {
        viewModelScope.launch {
            try {
                _imageParam.value = imageRepository.getImage()
            } catch (e: Exception){
                Log.d("ImageLoadError", e.message ?: "Error")
            }
        }
    }

}