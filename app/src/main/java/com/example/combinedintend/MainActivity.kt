package com.example.combinedintend

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val instIntend = findViewById<Button>(R.id.button1)
        val cameraIntend = findViewById<Button>(R.id.button2)
        val aboutIntend = findViewById<Button>(R.id.button3)

        instIntend.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.instagram.com/iam__rahulraj/")
            startActivity(intent)
        }

        cameraIntend.setOnClickListener {
            val intent = Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA)
            startActivity(intent)
        }

        aboutIntend.setOnClickListener {
            val intent = Intent(applicationContext, Aboutme_activity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}