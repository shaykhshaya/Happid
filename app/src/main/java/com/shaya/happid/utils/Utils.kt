package com.shaya.happid.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.shaya.happid.R

fun ImageView.loadCircleImageByUrl(context: Context, url: String?){
    Glide.with(context)
        .load(url)
        .circleCrop()
        .placeholder(R.drawable.ic_img_error)
        .error(R.drawable.ellipse_84)
        .into(this)
}