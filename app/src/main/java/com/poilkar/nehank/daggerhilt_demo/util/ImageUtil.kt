package com.poilkar.nehank.daggerhilt_demo.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageFromUrl(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .into(this)
}
