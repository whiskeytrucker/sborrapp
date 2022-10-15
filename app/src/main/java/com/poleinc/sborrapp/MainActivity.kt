package com.poleinc.sborrapp
//Seek bar = https://www.digitalocean.com/community/tutorials/android-media-player-song-with-seekbar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var mpBA: MediaPlayer
    lateinit var mbAUGH: MediaPlayer
    lateinit var sk: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonBrainAneurysm = findViewById<Button>(R.id.buttonBrainAneurysm)
        var buttonAUGH = findViewById<Button>(R.id.buttonAUGH)
        var buttonStop = findViewById<Button>(R.id.buttonStop)


        sk = findViewById<SeekBar>(R.id.seek_bar)
        mpBA = MediaPlayer.create(this, R.raw.brainaneurysm)
        mbAUGH = MediaPlayer.create(this, R.raw.augh)

        //sk.max = mpBA.duration/1000


        buttonBrainAneurysm.setOnClickListener() {
            if (!mpBA.isPlaying) {
                mpBA.start()
            } else {
                Toast.makeText(this, "Aspetta che finisca l'audio", Toast.LENGTH_LONG).show()
            }
        }

        buttonAUGH.setOnClickListener() {
            if (!mbAUGH.isPlaying) {
                mbAUGH.start()
            } else {
                Toast.makeText(this, "Aspetta che finisca l'audio", Toast.LENGTH_LONG).show()
            }
        }


        buttonStop.setOnClickListener() {
            if (mpBA.isPlaying) {
                mpBA.stop()
                mbAUGH.stop()
                mpBA.prepare()
                mbAUGH.prepare()
            } else {
                Toast.makeText(this, "Non c'è nessun audio da fermare", Toast.LENGTH_LONG).show()
            }
        }

    }
}