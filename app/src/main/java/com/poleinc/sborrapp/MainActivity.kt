package com.poleinc.sborrapp
//Seek bar = https://www.digitalocean.com/community/tutorials/android-media-player-song-with-seekbar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    lateinit var mpBA: MediaPlayer
    lateinit var mpAUGH: MediaPlayer
    lateinit var sk: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonBrainAneurysm = findViewById<Button>(R.id.buttonBrainAneurysm)
        var buttonAUGH = findViewById<Button>(R.id.buttonAUGH)
        var buttonStop = findViewById<Button>(R.id.buttonStop)

        sk = findViewById<SeekBar>(R.id.seek_bar)
        mpBA = MediaPlayer.create(this, R.raw.brainaneurysm)
        mpAUGH = MediaPlayer.create(this, R.raw.augh)

        //sk.max = mpBA.duration/1000


        buttonBrainAneurysm.setOnClickListener() {
            if (!mpBA.isPlaying) {
                initializeSeekBar(mpBA)
                mpBA.start()
            }
        }

        buttonAUGH.setOnClickListener() {
            if (!mpAUGH.isPlaying) {
                initializeSeekBar(mpAUGH)
                mpAUGH.start()
            }
        }


        buttonStop.setOnClickListener() {
            if (mpBA.isPlaying || mpAUGH.isPlaying) {
                mpBA.stop()
                mpAUGH.stop()
                mpBA.prepare()
                mpAUGH.prepare()
            }
        }

        sk.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mpBA?.seekTo(progress); mpAUGH?.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun initializeSeekBar(mp: MediaPlayer) {
        sk.max = mp!!.duration
        val handler = Handler()
        handler.postDelayed(object: Runnable {
            override fun run() {
                try{
                    sk.progress = mp!!.currentPosition
                    handler.postDelayed(this, 100)
                }catch(e: java.lang.Exception){
                    sk.progress = 0
                }
            }
        }, 0)
    }
}