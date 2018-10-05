package com.example.logonrmlocal.jokenballz

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*
import java.util.Random

class GameActivity : AppCompatActivity() {

    private val numAleatorio: Random? = null

    private val PEDRA = 1
    private val PAPEL = 1
    private val TESOURA = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        numAleatorio = Random()

        btPedra.setOnClickListener{
            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gokupedra))
            realizarJogada(PEDRA)
        }

        btPapel.setOnClickListener{
            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vegetapapel))
            realizarJogada(PAPEL)
        }

        btPedra.setOnClickListener {
            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gokutesoura))
            realizarJogada(TESOURA)
        }
    }

    private fun realizarJogada(jogadaPlayer: Int){
        val player = MediaPlayer.create(this, R.raw.joke)
    }




}
