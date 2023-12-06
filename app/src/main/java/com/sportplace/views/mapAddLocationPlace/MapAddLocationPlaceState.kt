package com.sportplace.views.mapAddLocationPlace

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.MapProperties

data class MapAddLocationPlaceState(
    val cameraPosition: CameraPosition,
    val selectedPlacePosition: LatLng = LatLng(Double.NaN, Double.NaN),
    val properties: MapProperties = MapProperties(),
)