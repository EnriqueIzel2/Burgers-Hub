package com.example.burgershub.domain.usecase

import com.example.burgershub.data.model.BurgerResponse
import com.example.burgershub.domain.repository.BurgerRepository
import javax.inject.Inject

class GetBurgersUseCase @Inject constructor(
  private val burgerRepository: BurgerRepository
) {

  suspend operator fun invoke(): List<BurgerResponse> {
    return burgerRepository.getBurgers()
  }
}