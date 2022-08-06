package com.amgdeveloper.imagedetailviewer.ui

import android.widget.ImageView
import com.amgdeveloper.imagedetailviewer.R
import com.squareup.picasso.Picasso

/**
 * Created by amgdeveloper
 */

fun ImageView.loadImage(url: String) {
    Picasso.get().load(url).placeholder(R.drawable.image_placeholder).into(this)
}