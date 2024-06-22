package com.example.car.Screens

import android.app.sdksandbox.SdkSandboxManager.SdkSandboxProcessDeathCallback
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.car.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    names: Array<String>,
    description: Array<String>,

) {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Car App",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            })
        },
    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            val nameCounte = names.size
            items(nameCounte){
                CarScreen(names = names, description = description , navController = navController , itemIndex = it )

            }
        }
    }


}

@Composable
fun CarScreen(
    modifier: Modifier = Modifier,
    names : Array<String>,
    description : Array<String>,
    navController: NavController,
    itemIndex : Int

) {
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentSize()
            .padding(15.dp)
            .clickable {
                navController.navigate("detail_screen/$itemIndex")
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),

        ) {
            Text(
                text =names[itemIndex] ,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = description[itemIndex],
                fontSize = 18.sp,
                lineHeight = 1.1.em
            )
        }
    }
}