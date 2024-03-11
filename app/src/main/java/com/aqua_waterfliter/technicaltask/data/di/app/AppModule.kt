package com.aqua_waterfliter.technicaltask.data.di.app

import android.app.Application
import android.content.Context
import com.aqua_waterfliter.technicaltask.data.api.ProductsApi
import com.aqua_waterfliter.technicaltask.data.di.RetrofitQ
import com.aqua_waterfliter.technicaltask.data.di.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @AppScope
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return logging
    }

    @Provides
    @AppScope
    fun providesOkHttpClient(okHttpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(okHttpLoggingInterceptor)
            .build()
    }


    @Provides
    @AppScope
    @RetrofitQ
    fun provideRetrofit(okHttpClient: OkHttpClient, urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(urlProvider.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    fun urlProvider() = UrlProvider()

    @Provides
    @AppScope
    fun competitionAPI(@RetrofitQ retrofit: Retrofit): ProductsApi = retrofit.create(
        ProductsApi::class.java
    )

    @Provides
    @AppScope
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

}