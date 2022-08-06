package com.amgdeveloper.imagedetailviewer.usecases

import com.amgdeveloper.imagedetailviewer.data.Repository
import com.amgdeveloper.imagedetailviewer.model.ImageData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

/**
 * Created by amgdeveloper
 */

@RunWith(MockitoJUnitRunner::class)
class GetImagesUseCaseTest {

    @Mock
    private lateinit var stateFlow: StateFlow<List<ImageData>>
    @Mock
    private lateinit var repository: Repository
    private lateinit var getImagesUseCase: GetImagesUseCase

    @Before
    fun setup() {
        getImagesUseCase = GetImagesUseCase(repository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getImages gets images from the repository`() = runTest {
        //Given
        whenever(repository.getImages()).thenReturn(stateFlow)

        //When
        val result = getImagesUseCase.invoke()

        //Then
        verify(repository).getImages()
        Assert.assertEquals(stateFlow, result)
    }
}