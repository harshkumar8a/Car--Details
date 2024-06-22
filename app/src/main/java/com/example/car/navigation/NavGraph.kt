package com.example.car.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.car.Screens.DetailScreen
import com.example.car.Screens.MainScreen
import com.example.car.data.Cars
import com.example.car.utils.Routes

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController : NavHostController

) {
    NavHost(navController = navController,
        startDestination = Routes.mainScreen.routes
    ) {
        composable(
            route = Routes.mainScreen.routes
        ){
            MainScreen(
                navController = navController,
                names = Cars.car,
                description = Cars.description
            )
        }
        composable(
            route = Routes.detailScreen.routes+"/{index}",
            arguments = listOf(
                navArgument("index"){
                    type =NavType.IntType
                }
            )
        ){index ->
            DetailScreen(
                navController = navController,
                name = Cars.car,
                description = Cars.description,
                imges = Cars.images,
                prices = Cars.carWithPrices,
                itemIndex = index.arguments?.getInt("index"),

                )
            
        }

    }

}