package com.example.shop_sultan_21.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ProductItem(
    @SerializedName("id")
    @Expose
    val id:Int,

    @SerializedName("title")
    @Expose
    val title:String,

    @SerializedName("price")
    @Expose
    val price:Double,

    @SerializedName("description")
    @Expose
    val description:String,

    @SerializedName("image")
    @Expose
    val image:String

): Serializable, Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),

        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(title)
        if (price == null) {
            dest.writeByte(0.toByte())
        } else {
            dest.writeByte(0.toByte())
            dest.writeDouble(price)
        }
        dest.writeString(description)
        dest.writeString(image)

    }

    companion object CREATOR : Parcelable.Creator<ProductItem> {
        override fun createFromParcel(parcel: Parcel): ProductItem {
            return ProductItem(parcel)
        }

        override fun newArray(size: Int): Array<ProductItem?> {
            return arrayOfNulls(size)
        }
    }
}
