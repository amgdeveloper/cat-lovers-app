package com.amgdeveloper.imagedetailviewer.data

import com.amgdeveloper.imagedetailviewer.data.source.ImageDataSource
import com.amgdeveloper.imagedetailviewer.di.IoDispatcher
import com.amgdeveloper.imagedetailviewer.model.ImageData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by amgdeveloper
 */
class Repository @Inject constructor(
    private val imageDataSource: ImageDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend fun getImages(): StateFlow<List<ImageData>> {
        var result : StateFlow<List<ImageData>>

        withContext(dispatcher) {
            result = imageDataSource.getImages()
        }
        return result
    }
}