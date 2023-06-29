package com.example.burgershub.data.repository

import com.example.burgershub.data.model.BurgerResponse
import com.example.burgershub.domain.repository.BurgerRepository

class BurgerRepositoryImpl : BurgerRepository {

  override suspend fun getBurgers(): List<BurgerResponse> {
    TODO("Not yet implemented")
  }

  override suspend fun getBurgerById(burgerId: Int): BurgerResponse {
    TODO("Not yet implemented")
  }

  override suspend fun getBurgerByName(name: String): List<BurgerResponse> {
    TODO("Not yet implemented")
  }

}