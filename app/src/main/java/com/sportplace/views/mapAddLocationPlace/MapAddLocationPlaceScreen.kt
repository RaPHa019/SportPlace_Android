package com.sportplace.views.mapAddLocationPlace

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState
import com.sportplace.components.Map
import com.sportplace.ui.theme.Blue
import com.sportplace.ui.theme.Gray

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MapAddLocationPlace(
    navController: NavController,
    viewModel: MapAddLocalPlaceViewModel = MapAddLocalPlaceViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    val cameraPositionState = rememberCameraPositionState {
        position = viewModel.state.value.cameraPosition
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Adicionar local", fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Blue
                        )
                    }
                },
                backgroundColor = Color.White,
                contentColor = Gray
            )
        }
    ) {
        Map(
            properties = viewModel.state.value.properties,
            cameraPositionState = cameraPositionState
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 20.dp)

            ) {
                Text(
                    text = "Pressione e segure o lugar em que quer adicionar o local para prosseguir",
                    modifier = Modifier.padding(15.dp),
                    textAlign = TextAlign.Center
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Blue
                ),
                content = {
                    Text(
                        text = "Continuar",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
            )
        }

    }
}
//
//@Preview
//@Composable
//fun MapAddLocationPreview(){
//    MapAddLocationPlace()
//}