package com.example.movieapp.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiData {


    @GET("marvel")
    fun getMovieInfo(): Call<List<DataModel>>
}