package com.example.recynestedgroupdate

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiKlien {
    companion object {
        fun ambilKlien() : Retrofit {
            val BASE_URL = "http://192.168.43.121/laravelandroid/"
            val retrofit: Retrofit = Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}