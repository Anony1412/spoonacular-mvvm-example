package com.ptit.example.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object BindingAdapter {

    private val requestOptions = RequestOptions().apply {
        transform(CenterCrop(), RoundedCorners(Constant.IMAGE_RADIUS))
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(image: ImageView, imageUrl: String) {
        Glide.with(image.context)
            .load(imageUrl)
            .apply(requestOptions)
            .into(image)
    }
}
