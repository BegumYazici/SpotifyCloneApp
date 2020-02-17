package com.alcsoft.spotifycloneapp1.radios

import com.alcsoft.spotifycloneapp1.radioModel.Radio
import retrofit2.Call
import retrofit2.http.GET

interface SpotifyApiService {

    //Verilerin alıncağı linkin path kısmını ve metodunu yazıyoruz.
    @GET("popularRadios.json")
    fun getPopularRadios() : Call<List<Radio>>

    @GET("locationRadios.json")
    fun getLocationRadios(): Call<List<Radio>>
}