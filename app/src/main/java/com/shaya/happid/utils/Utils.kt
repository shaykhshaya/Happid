package com.shaya.happid.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.shaya.happid.R

fun ImageView.loadCircleImageByUrl(context: Context, url: String?){
    Glide.with(context)
        .load(url)
        .circleCrop()
        .placeholder(R.drawable.ic_img_error)
        .error(R.drawable.ellipse_84)
        .into(this)
}

fun MaterialButton.toggleState(enable: Boolean){
    if (enable){
        isEnabled = true
        alpha = 1.0f
        setTextColor(ContextCompat.getColor(this.context, R.color.white))
    }else{
        isEnabled = false
        alpha = 0.5f
        setTextColor(ContextCompat.getColor(this.context, R.color.white_disabled))
    }
}


fun generateOTPFromMobileNumber(mobNum: String): String {
    return mobNum.substring(0, 2) + mobNum.substring(8, 10)
}

fun Dialog?.setRoundedWidth(){
    this?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    val layoutParams = this?.window?.attributes
    layoutParams?.width = WindowManager.LayoutParams.MATCH_PARENT
    this?.window?.attributes = layoutParams
}

fun appendCountryCode(mob: String?) = "+91 $mob"

fun isValidOTP(enteredOTP: String? , correctOTP: String?) = enteredOTP == correctOTP