package com.amgdeveloper.imagedetailviewer.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amgdeveloper.imagedetailviewer.model.ImageData
import com.amgdeveloper.imagedetailviewer.usecases.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by amgdeveloper
 *
 * ViewModel used to retrieve the ImageData
 *
 */
@HiltViewModel
class ImageViewModel @Inject constructor(private val getImagesUseCase: GetImagesUseCase) :
    ViewModel() {

    private val _images = MutableStateFlow(listOf<ImageData>())
    val images: StateFlow<List<ImageData>> get() = _images

    init {
        viewModelScope.launch {
            _images.value = getImagesUseCase.invoke().value
        }
    }
}