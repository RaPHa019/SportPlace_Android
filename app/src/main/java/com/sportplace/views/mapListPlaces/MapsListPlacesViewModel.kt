package com.sportplace.views.mapListPlaces

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.sportplace.components.MapStyle

class MapsListPlacesViewModel: ViewModel() {
    private val campinas = LatLng(-22.9563263,-47.0692034)

    private val mapProperties = MapProperties(
        mapStyleOptions = MapStyleOptions(MapStyle.json)
    )


    var state by mutableStateOf(MapState(cameraPosition = CameraPosition.fromLatLngZoom(campinas, 10f), properties = mapProperties))

}