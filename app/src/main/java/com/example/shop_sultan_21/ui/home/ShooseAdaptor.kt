package com.example.shop_sultan_21.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shop_sultan_21.R
import com.example.shop_sultan_21.databinding.ItemCardBinding
import com.example.shop_sultan_21.loadImage
import com.example.shop_sultan_21.models.ProductItem
import com.example.shop_sultan_21.visibility


class ShooseAdaptor(var contex: Context, var list:List<ProductItem>?)
    : RecyclerView.Adapter<ShooseAdaptor.ViewHolder>() {

    private lateinit var binding: ItemCardBinding
    var productT:ProductItem?=null

    var selected_intoBasketList: ArrayList<ProductItem> = ArrayList<ProductItem>()

   // fun getSelected_intoBasketList():ArrayList<ProductItem>{
  //      return selected_intoBasketList
 //   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShooseAdaptor.ViewHolder {
        binding = ItemCardBinding
            .inflate(LayoutInflater.from(contex),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShooseAdaptor.ViewHolder, position: Int) {
     list?.get(position)?.let{
         holder.onBind(it)
     }
    }

    override fun getItemCount(): Int {
        return list!!.size

    }

    inner class ViewHolder( binding: ItemCardBinding):RecyclerView.ViewHolder(binding.root)  {

        fun onBind(productItem: ProductItem) {

            binding.apply {
                nameProductCard.text =productItem.title
                priceCard.text = productItem.price.toString()
                descriptionCard.text = productItem.description
            }
            binding.imageCard.loadImage(productItem.image.toString())


            binding.btnZoom.setOnClickListener{v:View? ->
                productT = productItem
                var bundle = Bundle()
                bundle.putSerializable("key_as",productT)
                itemView.findNavController().navigate(R.id.notificationsFragment,bundle)
            }

            binding.btnBb.setOnClickListener{v2:View? ->

                    selected_intoBasketList.add(productItem);


             }
            }

        }

    }



