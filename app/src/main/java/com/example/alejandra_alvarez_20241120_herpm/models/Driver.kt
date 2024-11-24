package com.example.alejandra_alvarez_20241120_herpm.models

import android.graphics.Bitmap

data class Driver(
    val name: String,
    var photo: Bitmap? = null, // Foto del conductor, inicialmente nula
    val statistics: Int // Número de viajes
)
