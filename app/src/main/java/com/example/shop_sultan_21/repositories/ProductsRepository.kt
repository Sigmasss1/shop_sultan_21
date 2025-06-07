package com.example.shop_sultan_21.repositories

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shop_sultan_21.models.ProductItem
import com.example.shop_sultan_21.remote_data.LRetrofit
import com.example.shop_sultan_21.remote_data.ServisApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsRepository {
    companion object {
        private lateinit var servisApi: ServisApi

        init {
            try {
                servisApi = LRetrofit.retrofitService
            } catch (e: Exception) {
                Log.e(
                    "TAG", "ERROR!!" +
                            "Retrofit api_service creating is Failure!" + e.localizedMessage
                )
            }
        }
    }

    val data: MutableLiveData<ArrayList<ProductItem>?> = MutableLiveData<ArrayList<ProductItem>?>()

    @SuppressLint("SuspiciousIndentation")

    fun getProductLIst(): LiveData<ArrayList<ProductItem>?> {


        val apiCall: Call<ArrayList<ProductItem>> = servisApi.getStoreProducts()

        apiCall.enqueue(object : Callback<ArrayList<ProductItem>?> {

            override fun onResponse(call: Call<ArrayList<ProductItem>?>,
                                    response: Response<ArrayList<ProductItem>?> ) {
                try {
                    data.postValue(response.body())
                } catch (e: Exception) {
                    Log.e("TAG", "ERROR!! Failure set data to MutableLiveData" + e.localizedMessage)
                }
            }

            override fun onFailure(call: Call<ArrayList<ProductItem>?>, throwexeption: Throwable) {
                Log.e("TAG", "NO DATA FROM SERVER")
                data.postValue(null)
            }
        })
        return data


    }
}
