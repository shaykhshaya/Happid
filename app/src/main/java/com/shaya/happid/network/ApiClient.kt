package com.shaya.happid.network

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shaya.happid.MyApplication
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://www.google.com/"


class ApiClient {

    companion object{

        var retrofit: Retrofit? = null

        fun getClient(): Retrofit? {

            if(retrofit == null) {


                val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(ChuckerInterceptor(MyApplication.instance.applicationContext))
                    .build()
                val gson: Gson = GsonBuilder().create()


                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build()
            }

            return retrofit

        }


    }
}
