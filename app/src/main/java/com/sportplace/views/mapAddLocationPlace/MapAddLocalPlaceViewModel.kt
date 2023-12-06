package com.sportplace.views.mapAddLocationPlace

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.sportplace.components.MapStyle
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MapAddLocalPlaceViewModel: ViewModel() {
    private val campinas = LatLng(-23.9563263,-48.0692034)

    private val mapProperties = MapProperties(
        mapStyleOptions = MapStyleOptions(MapStyle.json)
    )


    val state: MutableState<MapAddLocationPlaceState> = mutableStateOf(MapAddLocationPlaceState(cameraPosition = CameraPosition.fromLatLngZoom(campinas, 10f), properties = mapProperties))

    private val _uiState = MutableStateFlow(MapAddLocationPlaceState(cameraPosition = CameraPosition.fromLatLngZoom(campinas, 10f), properties = mapProperties))
    val uiState: StateFlow<MapAddLocationPlaceState> = _uiState
    fun getDeviceLocation(
        fusedLocationProviderClient: FusedLocationProviderClient
    ) {
        /*
         * Get the best and most recent location of the device, which may be null in rare
         * cases when a location is not available.
         */
        try {
            val locationResult = fusedLocationProviderClient.lastLocation
            locationResult.addOnCompleteListener { task ->
                if (task.isSuccessful) {
//                    state.value = state.value.copy(
//                        cameraPosition = CameraPosition.fromLatLngZoom(LatLng(task.result.latitude, task.result.longitude), 5f),
//                    )

                    _uiState.update {
                        it.copy(
                            cameraPosition = CameraPosition.fromLatLngZoom(LatLng(task.result.latitude, task.result.longitude), 5f),
                        )
                    }

                }
            }
        } catch (e: SecurityException) {
            // Show error or something
        }
    }

}