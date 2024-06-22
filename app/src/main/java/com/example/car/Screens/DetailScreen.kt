package com.example.car.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.car.R
import com.example.car.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    name : Array<String>,
    description : Array<String>,
    itemIndex : Int?,
    imges : Array<Int>,
    prices : Array<String>

) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Routes.mainScreen.routes)
                            }
                            .padding(start = 5.dp,end = 10.dp),
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                },

                title = {
                    Text(
                        text = name[itemIndex!!],
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
            })
        },

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(20.dp)
                .padding(innerPadding),
        ) {

            AsyncImage(
                model = imges[itemIndex!!],
                contentDescription = null,
                modifier = Modifier.size(400.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "Description :",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = description[itemIndex],
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Prices - ${prices[itemIndex]}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
            )

        }
    }



}