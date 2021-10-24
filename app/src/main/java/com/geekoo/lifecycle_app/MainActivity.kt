package com.geekoo.lifecycle_app

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer : MediaPlayer? = null
    private var position: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.btnCheck).setOnClickListener{
            startActivity(Intent(this, Dialog::class.java))
        }

        Log.i("lIFECYCLE", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer =  MediaPlayer.create(this, R.raw.test)

        Log.i("lIFECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("lIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        position =  mediaPlayer!!.currentPosition
        Log.i("lIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i("lIFECYCLE", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lIFECYCLE", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lIFECYCLE", "onDestroy")
    }
}