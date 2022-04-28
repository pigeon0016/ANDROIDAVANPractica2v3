package com.example.androidavanpractica2v3


import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("/allrestarants")

    fun fetchAllRest(): Call<List<DmRestaurantes>>

}