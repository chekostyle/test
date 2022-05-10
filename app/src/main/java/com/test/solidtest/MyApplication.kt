package com.test.solidtest

import android.app.Application
import com.test.solidtest.di.implementations.LocalImageRepository
import com.test.solidtest.di.implementations.UrlImageRepository
import com.test.solidtest.di.implementations.WebServiceRepository
import com.test.solidtest.di.interfaces.IImageRepository
import com.test.solidtest.helpers.URL_API
import com.test.solidtest.retrofit.MoviesApiService
import com.test.solidtest.viewmodels.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}

val viewModelModule = module {
    viewModel { MainActivityViewModel(get(named("WS"))) }

}

val repositoryModule = module {
    single<IImageRepository>(named("Local")) { LocalImageRepository() }
    single<IImageRepository>(named("URL")) { UrlImageRepository() }
    single<IImageRepository>(named("WS")) { WebServiceRepository() }
}

val networkModule = module {

    single { retrofitInstance() }
    single { getMoviesApiService(get()) }

}

fun getMoviesApiService(retrofit: Retrofit): MoviesApiService {
    return retrofit.create(MoviesApiService::class.java)
}

private fun retrofitInstance() = Retrofit.Builder()
    .baseUrl(URL_API)
    .addConverterFactory(GsonConverterFactory.create())
    .build()