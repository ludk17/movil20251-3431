package com.upn.movil3431

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.LocationServices
import com.upn.movil3431.ui.theme.Movil3431Theme

class GPSActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Movil3431Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(innerPadding)
                }
            }
        }
    }
}



@SuppressLint("MissingPermission")
@Composable
fun Content(innerPadding: PaddingValues) {

    val context = LocalContext.current
    val locationService = LocationServices.getFusedLocationProviderClient(context)

    val requestPermission = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {}
    )

    var currentLongitude by remember { mutableDoubleStateOf(0.0) }
    var currentLatitude by remember { mutableDoubleStateOf(0.0) }


    Column (
        modifier = Modifier.fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("GPS Activity",
            style = typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("LATITUD: $currentLatitude")
        Text("LONGITUD: $currentLongitude")

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (isLocationPermissionGranted(context)) {
                locationService.lastLocation
                    .addOnSuccessListener { location ->
                        if(location != null) {
                            currentLatitude = location.latitude
                            currentLongitude = location.longitude
                        }
                    }
            } else {
                requestPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }) {
            Text("Obtener Ubicación")
        }
    }
}

fun isLocationPermissionGranted(context: Context): Boolean {
    return context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED
}
