package com.amgdeveloper.catlovers.data

import com.amgdeveloper.getFakeImageData
import com.amgdeveloper.catlovers.data.source.ImageDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
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
class RepositoryTest {

    @Mock
    private lateinit var imageDataSource: ImageDataSource
    private lateinit var repository: Repository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        repository = Repository(imageDataSource, UnconfinedTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getImages gets images from ImageDataSource`() = runTest {
        //Given
        val stateFlow = MutableStateFlow(getFakeImageData())
        whenever(imageDataSource.getImages()).thenReturn(stateFlow)

        //When
        val result = repository.getImages()

        //Then
        verify(imageDataSource).getImages()
        Assert.assertEquals(result, stateFlow)
    }
}