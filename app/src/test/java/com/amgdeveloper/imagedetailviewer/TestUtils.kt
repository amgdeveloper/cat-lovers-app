package com.amgdeveloper

import com.amgdeveloper.imagedetailviewer.model.ImageData

/**
 * Created by amgdeveloper
 */

fun getFakeImageData(): MutableList<ImageData> {
    val list = mutableListOf<ImageData>()
    list.add(
        ImageData(
            1,
            1,
            "some title 1",
            "https://via.placeholder.com/600/92c952",
            "https://via.placeholder.com/150/92c952"
        )
    )
    list.add(
        ImageData(
            2,
            2,
            "some title 2",
            "https://via.placeholder.com/600/771796",
            "=https://via.placeholder.com/150/771796"
        )
    )
    list.add(
        ImageData(
            3,
            1,
            "some title 3",
            "https://via.placeholder.com/600/24f355",
            "=https://via.placeholder.com/150/24f355"
        )
    )
    return list
}