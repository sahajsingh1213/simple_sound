package com.example.simple_sound

import android.content.ContentValues.TAG
import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio
import android.util.Log
import android.widget.Button
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var mediaAudio : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val url = "https://freetouse.com/data/mp3/damtaro/vision" // your URL here
        try {
            mediaAudio = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(url)
                prepare()
            }
        } catch (e: IllegalArgumentException) {
            Log.e(TAG, "Illegal Argument Exception: ${e.message}")
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        }


        val playB = findViewById<Button>(R.id.play_onButton)

        playB.setOnClickListener {
            mediaAudio.start()
        }

    }



  
}