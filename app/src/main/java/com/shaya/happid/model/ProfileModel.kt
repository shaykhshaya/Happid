package com.shaya.happid.model

data class ProfileModel(
    val imgUrl: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val location: String? = null,
    val postCode: String? = null
)
