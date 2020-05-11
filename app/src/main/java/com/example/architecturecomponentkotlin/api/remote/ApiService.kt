package com.example.architecturecomponentkotlin.api.remote

import com.example.architecturecomponentkotlin.model.Model
import com.example.architecturecomponentkotlin.model.ModelDetail
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface ApiService {

    @GET(Routes.GET_LIST)
    fun getList(@Header("Authorization") Authorization: String): Call<List<Model>>

    @GET(Routes.GET_LIST_DETAIL)
    fun getListDetail(@Header("Authorization") Authorization: String, @Path("id") id: String): Call<ModelDetail>
}