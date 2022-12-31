package com.shaya.happid.network

import com.shaya.happid.model.ProfileModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("createProfile")
    fun createProfile(
        @Body data: ProfileModel
    ) : Call<ResponseBody>

}