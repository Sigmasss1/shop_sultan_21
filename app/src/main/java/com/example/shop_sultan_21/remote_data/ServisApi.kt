package com.example.shop_sultan_21.remote_data


import com.example.shop_sultan_21.models.ProductItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT

interface ServisApi {

    @GET("products")
    fun getStoreProducts():Call<ArrayList<ProductItem>>




}