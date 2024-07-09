package com.example.car.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.car.Screens.DetailScreen
import com.example.car.Screens.MainScreen
import com.example.car.data.Cars
import com.example.car.utils.Routes

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController : NavHostController = rememberNavController()

) {

    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = Home ) {
            composable<Home>{
                MainScreen(
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this
                ){
                    navController.navigate(Detail(it))

                }

            }
            composable<Detail>{
                val detail:Detail = it.toRoute()
                DetailScreen(
                    index = detail.id,
                    sharedTransitionScope = this@SharedTransitionLayout ,
                    animatedVisibilityScope =  this,
                    navController = navController,

                ){
                    navController.navigateUp()
                }

            }

        }


    }


}