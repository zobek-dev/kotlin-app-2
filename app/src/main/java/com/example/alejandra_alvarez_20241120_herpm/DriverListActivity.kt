package com.example.alejandra_alvarez_20241120_herpm

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alejandra_alvarez_20241120_herpm.adapters.DriverAdapter
import com.example.alejandra_alvarez_20241120_herpm.models.Driver

class DriverListActivity : AppCompatActivity() {
    private val drivers = mutableListOf(
        Driver("John Doe", null, 120),
        Driver("Jane Smith", null, 95),
        Driver("Carlos García", null, 80),
        Driver("Sara Lee", null, 140),
        Driver("Mike Brown", null, 110),
        Driver("Anna White", null, 130)
    )
    private lateinit var adapter: DriverAdapter
    private var currentDriverPosition: Int? = null

    private lateinit var capturePhotoLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        adapter = DriverAdapter(drivers) { position ->
            currentDriverPosition = position
            val intent = Intent(this, CapturePhotoActivity::class.java)
            capturePhotoLauncher.launch(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Registrar el launcher para CapturePhotoActivity
        capturePhotoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val photo = result.data?.getParcelableExtra<Bitmap>("photo")
                if (photo != null) {
                    currentDriverPosition?.let { position ->
                        drivers[position].photo = photo
                        adapter.notifyItemChanged(position)
                    }
                } else {
                    Toast.makeText(this, "No se recibió ninguna foto.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Captura de foto cancelada.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
