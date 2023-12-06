package com.sportplace.views.mapListPlaces

import android.content.Context
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.sportplace.R

data class MapState(
    val cameraPosition: CameraPosition,
    val properties: MapProperties = MapProperties(),
)
