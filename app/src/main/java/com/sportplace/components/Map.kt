package com.sportplace.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings

@Composable
fun Map(
    properties: MapProperties,
    cameraPositionState: CameraPositionState,
) {
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = properties,
        uiSettings = uiSettings,
        cameraPositionState = cameraPositionState
    )
}