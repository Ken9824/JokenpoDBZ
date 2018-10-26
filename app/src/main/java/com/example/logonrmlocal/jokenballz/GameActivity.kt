package com.example.logonrmlocal.jokenballz

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*
import java.util.Random

class GameActivity : AppCompatActivity() {

    private var numAleatorio: Random? = null
    var vidas = 3
    var score = 0

    private val PEDRA = 1
    private val PAPEL = 2
    private val TESOURA = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tvVidas!!.text = "Vidas: " + vidas
        tvScore!!.text = "Score: " + score

        numAleatorio = Random()

        btPedra.setOnClickListener{
            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gokupedra))
            realizarJogada(PEDRA)
        }

        btPapel.setOnClickListener{
            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vegetapapel))
            realizarJogada(PAPEL)
        }

        btTesoura.setOnClickListener {
            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gokutesoura))
            realizarJogada(TESOURA)
        }
    }

    private fun realizarJogada(jogadaPlayer: Int){
        val jogadaPC = numAleatorio!!.nextInt(3) + 1

        when(jogadaPC){
            PEDRA -> {ivjogadaPC!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gokupedra))
                when(jogadaPlayer){
                    PAPEL -> venceu()
                    PEDRA -> empatou()
                    TESOURA -> perdeu()
                }
            }

            PAPEL -> {ivjogadaPC!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vegetapapel))
                when(jogadaPlayer){
                    PAPEL -> empatou()
                    PEDRA -> perdeu()
                    TESOURA -> venceu()
                }
            }

            TESOURA -> {ivjogadaPC!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gokutesoura))
                when(jogadaPlayer) {
                    PAPEL -> perdeu()
                    PEDRA -> venceu()
                    TESOURA -> empatou()
                }

            }
        }
    }

    private fun venceu(){
        tvResultado!!.text = getString(R.string.venceu)
        score += 2000
        tvScore!!.text = "Score: " + score
    }

    private fun perdeu(){
        tvResultado!!.text = getString(R.string.perdeu)
        vidas -= 1
        tvVidas!!.text = "Vidas: " + vidas

        if(vidas <= 0){
            val intent = Intent(this, DerrotaActivity::class.java)
            startActivity(intent)

            val intentRecebe = Intent(this, DerrotaActivity::class.java)
            intentRecebe.putExtra("Score", score)
            startActivity(intentRecebe)
            finish()
        }

    }

    private fun empatou(){
        tvResultado!!.text = getString(R.string.empatou)
        score += 1000
        tvScore!!.text = "Score: " + score

    }

}
