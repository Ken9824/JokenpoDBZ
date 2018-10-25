package com.example.logonrmlocal.jokenballz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_derrota.*
import kotlinx.android.synthetic.main.activity_splash.*

class DerrotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_derrota)

        Glide.with(this)
                .load(R.drawable.sadgoku)
                .asGif()
                .into(ivGokuSad)

        var recebeScore = getIntent().getIntExtra("Score ", 0)
        tvscoreRecebe!!.text = "Score Final: " + recebeScore.toString()

        btJogarNovamente.setOnClickListener{
           val intent = Intent(this@DerrotaActivity, GameActivity::class.java)
            startActivity(intent)
        }



    }

}
