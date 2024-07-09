package com.example.car.Screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.car.R
import com.example.car.data.Cars
import com.example.car.data.Cars.car
import com.example.car.data.DataCar
import com.example.car.navigation.Home
import com.example.car.utils.Routes

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    index : Int,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    navController: NavController,
    onNavigate : () -> Unit,

) {
    with(sharedTransitionScope){

        val car = Cars.car[index]

        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        Icon(
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(Home)
                                }
                                .padding(start = 5.dp, end = 10.dp),
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    },

                    title = {
                        Text(
                            text = car.name ,
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp
                        )
                    })
            },

            ) { innerPadding ->


            LazyColumn(

                contentPadding = innerPadding,
                modifier = Modifier.padding(8.dp)
            ) {
                item {
                    AsyncImage(
                        model = car.image,
                        contentDescription =null,
                        modifier = Modifier
                            .sharedElement(
                                state = rememberSharedContentState(key = "image/${car.id}"),
                                animatedVisibilityScope = animatedVisibilityScope
                            )
                            .fillMaxWidth()
                            .height(346.dp),
                        alignment = Alignment.CenterStart,
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        modifier = Modifier
                            .sharedElement(
                                state = rememberSharedContentState(key = "text/${car.name}"),
                                animatedVisibilityScope = animatedVisibilityScope
                            ),
                        text = car.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    CarInfoItem(name = car.name, description = car.description , price = car.prices, animatedVisibilityScope = animatedVisibilityScope)

                }

            }



    }

}}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.CarInfoItem(
    modifier: Modifier = Modifier,
    name : String,
    description : String,
    price : String,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Column(
        modifier = Modifier

    ) {

        Spacer(modifier = Modifier.height(10.dp))



        Text(
            text = description,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Prices - $price",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
        )

    }
}
