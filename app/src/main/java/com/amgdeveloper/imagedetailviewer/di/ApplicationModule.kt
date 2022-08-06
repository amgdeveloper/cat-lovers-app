package com.amgdeveloper.imagedetailviewer.di

import android.content.Context
import android.content.res.AssetManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by amgdeveloper
 *
 * Module used to inject the dependencies that must be shared across the app
 *
 */

@InstallIn(SingletonComponent::class)
@Module
class ApplicationModule {

    @Provides
    fun provideAssetManager(@ApplicationContext context: Context): AssetManager = context.assets
}