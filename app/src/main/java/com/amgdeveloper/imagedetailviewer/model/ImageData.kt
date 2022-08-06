package com.amgdeveloper.imagedetailviewer.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by amgdeveloper
 *
 * Representation of the ImageData
 *
 */
@Parcelize
data class ImageData(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)  : Parcelable

