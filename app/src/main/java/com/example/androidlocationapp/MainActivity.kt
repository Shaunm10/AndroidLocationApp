package com.example.androidlocationapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import android.Manifest
import android.widget.Toast
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.androidlocationapp.ui.theme.AndroidLocationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidLocationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Android")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun LocationDisplay(
    locationUtils: LocationUtils,
    context: Context
) {

    // request permission from the system
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        // a callback on the result of the request.
        onResult = { permissions ->

            // if we did obtain the permission for the
            if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true &&
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
            ) {
                // permission is granted.

            } else {

                // permission is not granted so ask for permission,
                // this is explaining to the user why we need the permission
                val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )

                // if we need to let the user know why we need the permission
                if (rationaleRequired) {
                    Toast.makeText(
                        context,
                        "Location is required for this feature to work.", Toast.LENGTH_LONG
                    ).show()

                }
            }
        })
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Location not available")
        Button(onClick = {

            if (locationUtils.hasLocationPermission(context)) {
                // permission granted
            } else {
                // request location permission
            }
        }) {
            Text(text = "Get Location")

        }

    }

}