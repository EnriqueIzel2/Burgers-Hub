package com.example.burgershub.domain.usecase

import com.example.burgershub.data.model.BurgerResponse
import com.example.burgershub.domain.repository.BurgerRepository
import javax.inject.Inject

class GetBurgersByNameUseCase @Inject constructor(
  private val burgerRepository: BurgerRepository
) {

  suspend operator fun invoke(name: String): List<BurgerResponse> {
    return burgerRepository.getBurgerByName(name)
  }
}