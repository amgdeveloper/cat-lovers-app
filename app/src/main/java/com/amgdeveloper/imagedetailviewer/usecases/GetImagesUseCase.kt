package com.amgdeveloper.imagedetailviewer.usecases

import com.amgdeveloper.imagedetailviewer.data.Repository
import com.amgdeveloper.imagedetailviewer.model.ImageData
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Created by amgdeveloper
 *
 * Use case to retrieve the Image Data model
 *
 */
class GetImagesUseCase @Inject constructor(private val repository: Repository) {

    suspend fun invoke(): StateFlow<List<ImageData>> {
        return repository.getImages()
    }
}