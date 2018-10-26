package com.example.logonrmlocal.jokenballz

import android.content.Intent
import android.drm.DrmStore
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        vvVideo.setVideoURI(Uri.parse("android.resource://" +getPackageName()+ "/"+R.raw.jokenpogokuvegeta));
        vvVideo.setMediaController(MediaController(this));
        vvVideo.requestFocus();
        vvVideo.start();
        vvVideo.setMediaController(null)

        //Botão Jogar
        btJogar.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)
        }

        btRanking.setOnClickListener {
            val intent = Intent(this@MainActivity, RankingActivity::class.java)
            startActivity(intent)
        }

        btSobre.setOnClickListener {
            val intent = Intent(this@MainActivity, SobreActivity::class.java)
            startActivity(intent)
        }

        btSair.setOnClickListener {
            finishAffinity()
        }

    }



}
