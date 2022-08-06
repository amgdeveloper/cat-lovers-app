package com.amgdeveloper.catlovers.usecases

import com.amgdeveloper.catlovers.data.Repository
import com.amgdeveloper.catlovers.model.ImageData
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