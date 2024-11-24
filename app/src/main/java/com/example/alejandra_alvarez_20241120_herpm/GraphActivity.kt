package com.example.alejandra_alvarez_20241120_herpm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class GraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        val barChart = findViewById<BarChart>(R.id.bar_chart)

        val entries = listOf(
            BarEntry(1f, 120f),
            BarEntry(2f, 150f),
            BarEntry(3f, 90f),
            BarEntry(4f, 170f)
        )

        val dataSet = BarDataSet(entries, "Viajes por Conductor")
        val data = BarData(dataSet)

        barChart.data = data
        barChart.invalidate()
    }
}
