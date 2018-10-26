package com.example.logonrmlocal.jokenballz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.logonrmlocal.jokenballz.api.dbzapi
import com.example.logonrmlocal.jokenballz.model.Pontos
import okhttp3.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

class RankingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)



        val retrofit = Retrofit.Builder()
                .baseUrl("https://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(dbzapi::class.java!!)

        service.buscarPontos()
                .enqueue(object : retrofit2.Callback<List<Pontos>> {
                    override fun onFailure(call: Call<List<Pontos>>?, t: Throwable?) {
                        Log.i("Erro", "Deu ruim")
                    }

                    override fun onResponse(call: Call<List<Pontos>>?, response: retrofit2.Response<List<Pontos>>?) {
                        val pontuacao = response?.body()
                        for(pont in pontuacao!!) {
                            Log.i("PONTUACAO", "${pont.nome} - ${pont.pontos}")
                        }
                    }
                })


    }
}
