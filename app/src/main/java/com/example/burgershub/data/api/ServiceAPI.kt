package com.example.burgershub.data.api

import com.example.burgershub.data.model.BurgerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {

  @GET("burgers")
  suspend fun getBurgers(): List<BurgerResponse>

  @GET("burgers/{burger_id}")
  suspend fun getBurgerById(@Path("burger_id") burgerId: Int): BurgerResponse

  @GET("find-burger/")
  suspend fun getBurgerByName(@Query("search") name: String): List<BurgerResponse>
}