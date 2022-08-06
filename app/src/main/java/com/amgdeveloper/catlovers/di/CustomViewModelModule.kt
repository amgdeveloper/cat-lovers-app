package com.amgdeveloper.catlovers.di

import com.amgdeveloper.catlovers.data.source.ImageDataSource
import com.amgdeveloper.catlovers.data.source.LocalImageDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by amgdeveloper
 *
 * Module used to provide the dependencies for the ViewModel
 */

@InstallIn(ViewModelComponent::class)
@Module
abstract class CustomViewModelModule {

    @Binds
    abstract fun bindImageDataSource(localImageDataSource: LocalImageDataSource) : ImageDataSource
}