package com.example.androidlocationapp

import android.content.Context
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat


class LocationUtils(val context: Context) {

    fun hasLocationPermission(context: Context): Boolean {

        val hasFineLocation = (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)

        val hasCoarseLocation = (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)

        return hasFineLocation && hasCoarseLocation
    }
}