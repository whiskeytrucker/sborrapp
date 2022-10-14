package com.poleinc.sborrapp
//Seek bar = https://www.digitalocean.com/community/tutorials/android-media-player-song-with-seekbar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var mp: MediaPlayer
    lateinit var sk: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonPlay = findViewById<Button>(R.id.buttonPlay)
        var buttonStop = findViewById<Button>(R.id.buttonStop)

        sk = findViewById<SeekBar>(R.id.seek_bar)
        mp = MediaPlayer.create(this, R.raw.brainaneurysm)

        sk.max = mp.duration/1000


        buttonPlay.setOnClickListener(){
            if(!mp.isPlaying){
                reproduce()
            }else{
                Toast.makeText(this, "Aspetta che finisca l'audio", Toast.LENGTH_LONG).show()
            }
        }

        buttonStop.setOnClickListener(){
            if(mp.isPlaying) {
                stop()
            }else{
                Toast.makeText(this, "Non c'è nessun audio da fermare", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun reproduce(){
        mp.start()
    }

    private fun stop(){
        mp.stop()
        mp.prepare()
    }

}