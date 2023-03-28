package com.example.nutritiontracker

import android.os.Parcel
import android.os.Parcelable

class Food () : Parcelable {

    var name: String
    var calories: String

    init {
        name = ""
        calories = ""
    }

    constructor(ini: Parcel) : this() {
        name = ini.readString().toString()
        calories = ini.readString().toString()
    }
    constructor(name: String, calories: String) : this() {
        this.name = name
        this.calories = calories
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        out.writeString(name)
        out.writeString(calories)
    }


    companion object CREATOR : Parcelable.Creator<Food?> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }
}