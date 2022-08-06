package com.amgdeveloper.imagedetailviewer.data.source

import com.amgdeveloper.imagedetailviewer.model.ImageData
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by amgdeveloper
 *
 * Interface to be implemented by the different ImageData data sources
 *
 */
interface ImageDataSource {

    suspend fun getImages(): StateFlow<List<ImageData>>
}