package com.example.logonrmlocal.jokenballz.api

import android.telecom.Call
import com.example.logonrmlocal.jokenballz.model.Pontos
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface dbzapi {
    @GET("/jokenpokemon/pontuacao")
    fun buscarPontos() : retrofit2.Call<List<Pontos>>

    @POST("/jokenpokemon/pontuacao")
    fun salvarPontos(@Body pontuacao: Pontos) : retrofit2.Call<Void>

}