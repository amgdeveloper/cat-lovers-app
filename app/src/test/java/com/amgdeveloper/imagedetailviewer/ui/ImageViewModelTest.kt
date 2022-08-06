package com.amgdeveloper.imagedetailviewer.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amgdeveloper.getFakeImageData
import com.amgdeveloper.imagedetailviewer.testutilities.CoroutineTestRule
import com.amgdeveloper.imagedetailviewer.data.Repository
import com.amgdeveloper.imagedetailviewer.data.source.ImageDataSource
import com.amgdeveloper.imagedetailviewer.model.ImageData
import com.amgdeveloper.imagedetailviewer.usecases.GetImagesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by amgdeveloper
 */

@RunWith(MockitoJUnitRunner::class)
class ImageViewModelTest {


    @OptIn(ExperimentalCoroutinesApi::class)
    private var dispatcher: CoroutineDispatcher = UnconfinedTestDispatcher()
    private lateinit var imageViewModel: ImageViewModel
    private lateinit var useCase: GetImagesUseCase
    private lateinit var repository: Repository

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val rule = CoroutineTestRule(dispatcher)

    @Before
    fun setup() {
        repository = Repository(FakeImageDataSource(), dispatcher)
        useCase = GetImagesUseCase(repository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `data is received when initializing the view model`() = runTest {
        //Given
        val data = getFakeImageData()

        //When
        imageViewModel = ImageViewModel(useCase)

        //Then
        Assert.assertEquals(data, imageViewModel.images.value)
    }


    class FakeImageDataSource : ImageDataSource {
        override suspend fun getImages(): StateFlow<List<ImageData>> {
            return MutableStateFlow(getFakeImageData())
        }
    }
}