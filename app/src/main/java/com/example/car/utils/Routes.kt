package com.example.car.utils

sealed class Routes(val routes:String) {

    object mainScreen : Routes("main_screen")
    object detailScreen : Routes("detail_screen")

}