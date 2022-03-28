package com.example.movieapp.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.ApiData
import com.example.movieapp.model.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel : ViewModel() {
    var BASE_URL = "https://simplifiedcoding.net/demos/"
    var movieInfo = MutableLiveData<List<DataModel>>()
    var movieObject = ArrayList<DataModel>()

    var info = ObservableField<String>()


    fun movieDetails() {
        var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        var serivce = retrofit.create(ApiData::class.java)
        var serviceCall = serivce.getMovieInfo()

        serviceCall.enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                val data = response.body()
                Log.d("data", "" + data)
                for (i in data!!) {
                    movieObject.add(i)
                }
                movieInfo.value = movieObject
                // Log.d("apidata",""+weatherInfo)
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                info.set("check network")

            }
        })

    }
}


