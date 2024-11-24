package com.example.alejandra_alvarez_20241120_herpm

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CapturePhotoActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var captureButton: Button
    private lateinit var confirmButton: Button
    private var capturedPhoto: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture_photo)

        imageView = findViewById(R.id.captured_photo)
        captureButton = findViewById(R.id.btn_capture)
        confirmButton = findViewById(R.id.btn_confirm)

        captureButton.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }

        confirmButton.setOnClickListener {
            capturedPhoto?.let {
                val resultIntent = Intent()
                resultIntent.putExtra("photo", it)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val photo = data?.extras?.get("data") as Bitmap
            capturedPhoto = photo
            imageView.setImageBitmap(photo)
            confirmButton.isEnabled = true
        }
    }
}
