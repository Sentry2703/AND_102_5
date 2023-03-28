package com.example.nutritiontracker

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class MyParcelable private constructor(`in`: Parcel) : Parcelable {
    private val mData: Int
    private val nData: Int
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        out.writeInt(mData)
        out.writeInt(nData)
    }

    init {
        mData = `in`.readInt()
        nData = `in`.readInt()
    }

    companion object CREATOR : Creator<MyParcelable> {
        override fun createFromParcel(parcel: Parcel): MyParcelable {
            return MyParcelable(parcel)
        }

        override fun newArray(size: Int): Array<MyParcelable?> {
            return arrayOfNulls(size)
        }
    }
}