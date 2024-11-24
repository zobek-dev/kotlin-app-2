package com.example.alejandra_alvarez_20241120_herpm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        // Para Lottie Animation
        val animationView = findViewById<LottieAnimationView>(R.id.animation_view)
        animationView.setAnimation(R.raw.transport_animation) // Archivo JSON
        animationView.playAnimation()
    }
}
