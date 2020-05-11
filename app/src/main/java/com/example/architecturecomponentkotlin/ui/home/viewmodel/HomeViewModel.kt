package com.example.architecturecomponentkotlin.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturecomponentkotlin.api.local.dao.ModelDao
import com.example.architecturecomponentkotlin.api.remote.ApiService
import com.example.architecturecomponentkotlin.api.remote.Routes
import com.example.architecturecomponentkotlin.model.Model
import com.example.architecturecomponentkotlin.model.ModelDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class HomeViewModel(private val modelDao: ModelDao, private val apiService: ApiService) : ViewModel() {


    private val detailModelLiveData = MutableLiveData<ModelDetail>()
    val getModelDetailLiveData:LiveData<ModelDetail>
        get() = detailModelLiveData

    init {
        initNetworkRequest()
    }

    private fun initNetworkRequest() {
        val call = apiService.getList(Routes.HEADER)
        call.enqueue(object : Callback<List<Model>?> {
            override fun onResponse(
                call: Call<List<Model>?>?,
                response: Response<List<Model>?>?
            ) {
                response?.body()?.let { models: List<Model> ->
                    thread {
                        modelDao.add(models)
                    }
                }
            }

            override fun onFailure(call: Call<List<Model>?>?, t: Throwable?) {
            }
        })
    }


    fun getListModel(): LiveData<List<Model>> {
        return modelDao.all()
    }

    fun getDetailById(id: String){
        val call = apiService.getListDetail(Routes.HEADER,id)
        call.enqueue(object : Callback<ModelDetail> {
            override fun onResponse(
                call: Call<ModelDetail>?,
                response: Response<ModelDetail>
            ) {
                response?.body()?.let { detailModels: ModelDetail ->
                    thread {
                        detailModelLiveData.postValue(detailModels)
                    }
                }
            }

            override fun onFailure(call: Call<ModelDetail>, t: Throwable?) {
            }
        })
    }

}