package com.example.logonrmlocal.jokenballz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.logonrmlocal.jokenballz.api.dbzapi
import com.example.logonrmlocal.jokenballz.model.Pontos
import kotlinx.android.synthetic.main.activity_derrota.*
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.StreamCorruptedException

class DerrotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_derrota)
        val bundle = intent.extras
        val score = bundle.getInt("Score")

        Glide.with(this)
                .load(R.drawable.sadgoku)
                .asGif()
                .into(ivGokuSad)


        tvscoreRecebe!!.text = "Score Final: " + score.toString()

        btJogarNovamente.setOnClickListener{
           val intent = Intent(this@DerrotaActivity, GameActivity::class.java)
            startActivity(intent)
        }

        btSalvar.setOnClickListener{
            val pontuacao = Pontos(etNome.text.toString(), score)
            getDBZAPI()
                    .salvarPontos(pontuacao)
                    .enqueue(object : Callback<Void> {
                        override fun onFailure(call: Call<Void>?, t: Throwable?) {
                            exibirMensagemErro()
                        }

                        override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                            if (response?.isSuccessful == true) {
                                exibirMensagemSucesso()

                            } else {
                                exibirMensagemErro()
                            }
                        }
                    })
        }

        btVoltaMenu.setOnClickListener{
            val intent = Intent(this@DerrotaActivity, MainActivity::class.java)
            startActivity(intent)
        }



    }

    private fun exibirMensagemSucesso() {
        Toast.makeText(this, "Gravado", Toast.LENGTH_LONG).show()
    }

    private fun exibirMensagemErro() {
        Toast.makeText(this, "Deu erro", Toast.LENGTH_LONG).show()
    }
    private fun getDBZAPI(): dbzapi {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
                .create<dbzapi>(dbzapi::class.java)
    }
}
