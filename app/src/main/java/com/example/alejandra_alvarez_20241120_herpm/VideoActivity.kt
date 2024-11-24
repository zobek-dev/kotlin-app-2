package com.example.alejandra_alvarez_20241120_herpm

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoView = findViewById<VideoView>(R.id.video_view)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.transport_video
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
}