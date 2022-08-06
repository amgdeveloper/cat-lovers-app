package com.amgdeveloper.catlovers.data.source

import android.content.res.AssetManager
import com.amgdeveloper.catlovers.model.ImageData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.reflect.Type
import javax.inject.Inject


/**
 * Created by amgdeveloper
 *
 * Local implementation of the ImageDataSource, using the asset manager
 */
class LocalImageDataSource @Inject constructor(private val assetManager: AssetManager) : ImageDataSource {

    override suspend fun getImages(): StateFlow<List<ImageData>> {
        val flow = MutableStateFlow<List<ImageData>>(emptyList())
        val result = assetManager.readAssetsFile("images.json")
        val imageDataType: Type = object : TypeToken<List<ImageData?>?>() {}.type
        flow.value = Gson().fromJson(result, imageDataType)
        return flow
    }
}

fun AssetManager.readAssetsFile(fileName: String): String =
    open(fileName).bufferedReader().use { it.readText() }