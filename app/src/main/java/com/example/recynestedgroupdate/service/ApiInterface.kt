package com.example.recynestedgroupdate

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("person.php")
    fun getPerson() : Call<List<ModelNya>>

}