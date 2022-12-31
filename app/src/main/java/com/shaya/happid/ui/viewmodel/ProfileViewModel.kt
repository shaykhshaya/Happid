package com.shaya.happid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shaya.happid.model.ProfileModel
import com.shaya.happid.repository.ProfileRepository
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class ProfileViewModel: ViewModel() {

    private val repository = ProfileRepository()

    var createProfileLiveData : MutableLiveData<Response<ResponseBody>?> = MutableLiveData()

    fun createProfile(data: ProfileModel) {
        repository.createProfile(data)?.enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
               createProfileLiveData.value = response
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                createProfileLiveData.value = null
            }

        })
    }

}