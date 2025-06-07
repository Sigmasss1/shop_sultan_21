package com.example.shop_sultan_21

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun View.visibility(isVisible: Boolean){
    if (isVisible==true){
        this.visibility=View.VISIBLE
    }else{
        this.visibility = View.GONE
    }
}
fun ImageView.loadImage(uri: String){
    Glide
        .with(this)
        .load(uri)
        .centerCrop()
        .placeholder(R.drawable.place_holder_my)
        .error(R.drawable.ic_launcher_background)
        .into(this)
}
fun showToast(context: Context, msg:String){
    Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
}