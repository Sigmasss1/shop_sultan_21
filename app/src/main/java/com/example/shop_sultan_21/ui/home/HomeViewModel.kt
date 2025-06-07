package com.example.shop_sultan_21.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shop_sultan_21.models.ProductItem
import com.example.shop_sultan_21.repositories.ProductsRepository

class homeViewModel: ViewModel(){

    var repository:ProductsRepository = ProductsRepository()


    private var responseLiveData: LiveData<ArrayList<ProductItem>?> = MutableLiveData()

    fun getFetchLiveData(): LiveData<ArrayList<ProductItem>?>{


        responseLiveData = repository.getProductLIst()

        return responseLiveData
    }

}