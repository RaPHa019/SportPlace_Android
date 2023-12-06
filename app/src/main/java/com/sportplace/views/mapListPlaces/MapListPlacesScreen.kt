package com.sportplace.views.mapListPlaces

import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.maps.android.compose.rememberCameraPositionState
import com.sportplace.components.Map
import com.sportplace.ui.theme.Blue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MapListPlacesScreen(
    navController: NavController,
    viewModel: MapsListPlacesViewModel = MapsListPlacesViewModel()

) {
    val scaffoldState = rememberScaffoldState()
    val cameraPositionState = rememberCameraPositionState() {
        position = viewModel.state.cameraPosition
    }

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("mapAppLocationPlace")
                },
                backgroundColor = Blue,
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Adicionar novo local", tint = Color.White)
            }
        }

    ) {
        Map(
            properties = viewModel.state.properties,
            cameraPositionState = cameraPositionState
        )
    }
}