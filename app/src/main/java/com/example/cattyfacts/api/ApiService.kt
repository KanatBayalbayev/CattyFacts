package com.example.cattyfacts.api

import com.example.cattyfacts.pojo.Data
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/")
    fun getFact() : Single<Data>

}