package com.shaya.happid.repository

import com.shaya.happid.network.ApiInterface
import com.shaya.happid.model.ProfileModel
import com.shaya.happid.network.ApiClient

class ProfileRepository  {
    
    private val retrofit = ApiClient.getClient()
    private val api = retrofit?.create(ApiInterface::class.java)

    fun createProfile(data: ProfileModel) = api?.createProfile(data)


}