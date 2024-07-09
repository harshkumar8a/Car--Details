package com.example.car.data

import androidx.annotation.DrawableRes

data class DataCar(
    val id : Int,
    val name : String,
    val description : String,
    @DrawableRes val image : Int,
    val prices : String

)