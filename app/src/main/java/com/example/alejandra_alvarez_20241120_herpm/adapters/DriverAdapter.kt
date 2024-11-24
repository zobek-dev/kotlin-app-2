package com.example.alejandra_alvarez_20241120_herpm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alejandra_alvarez_20241120_herpm.R
import com.example.alejandra_alvarez_20241120_herpm.models.Driver

class DriverAdapter(
    private val drivers: List<Driver>,
    private val onPhotoClick: (Int) -> Unit
) : RecyclerView.Adapter<DriverAdapter.DriverViewHolder>() {

    inner class DriverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val driverPhoto: ImageView = itemView.findViewById(R.id.driver_photo)
        val driverName: TextView = itemView.findViewById(R.id.driver_name)
        val driverStatistics: TextView = itemView.findViewById(R.id.driver_statistics)
        val btnUploadPhoto: Button = itemView.findViewById(R.id.btn_upload_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_driver, parent, false)
        return DriverViewHolder(view)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        val driver = drivers[position]
        holder.driverName.text = driver.name
        holder.driverStatistics.text = "Viajes: ${driver.statistics}"

        // Configurar la foto del conductor
        if (driver.photo != null) {
            holder.driverPhoto.setImageBitmap(driver.photo)
            holder.btnUploadPhoto.text = "Cambiar Imagen"
        } else {
            holder.driverPhoto.setImageResource(R.drawable.ic_driver_placeholder)
            holder.btnUploadPhoto.text = "Subir Imagen"
        }

        // Manejar el clic en el botón de subir/cambiar foto
        holder.btnUploadPhoto.setOnClickListener {
            onPhotoClick(position)
        }
    }

    override fun getItemCount(): Int = drivers.size
}
