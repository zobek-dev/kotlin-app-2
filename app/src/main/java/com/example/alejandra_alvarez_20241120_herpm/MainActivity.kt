package com.example.alejandra_alvarez_20241120_herpm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAnimation = findViewById<Button>(R.id.btn_animation)
        val btnVideo = findViewById<Button>(R.id.btn_video)
        val btnDriverList = findViewById<Button>(R.id.btn_driver_list)
        //val btnCapturePhoto = findViewById<Button>(R.id.btn_capture_photo)
        val btnGraph = findViewById<Button>(R.id.btn_graph)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Título de la Actividad"

        btnAnimation.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }

        btnVideo.setOnClickListener {
            startActivity(Intent(this, VideoActivity::class.java))
        }

        btnDriverList.setOnClickListener {
            startActivity(Intent(this, DriverListActivity::class.java))
        }

        //btnCapturePhoto.setOnClickListener {
        //    startActivity(Intent(this, CapturePhotoActivity::class.java))
        //}

        btnGraph.setOnClickListener {
            startActivity(Intent(this, GraphActivity::class.java))
        }
    }
}
