package com.example.burgershub.presenter.burgers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.burgershub.data.model.ErrorResponse
import com.example.burgershub.domain.usecase.GetBurgersByNameUseCase
import com.example.burgershub.domain.usecase.GetBurgersUseCase
import com.example.burgershub.util.StateView
import com.example.burgershub.util.getErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class BurgerViewModel @Inject constructor(
  private val getBurgersUseCase: GetBurgersUseCase,
  private val getBurgersByNameUseCase: GetBurgersByNameUseCase
) : ViewModel() {

  fun getBurgers() = liveData(Dispatchers.IO) {
    try {
      emit(StateView.Loading())
      val burgers = getBurgersUseCase()
      emit(StateView.Success(burgers))

    } catch (e: HttpException) {
      e.printStackTrace()
      val error = e.getErrorResponse<ErrorResponse>()
      emit(StateView.Error(error?.message))

    } catch (e: Exception) {
      e.printStackTrace()
      emit(StateView.Error(e.message))
    }
  }

  fun getBurgersByName(name: String) = liveData(Dispatchers.IO) {
    try {
      emit(StateView.Loading())
      val burgers = getBurgersByNameUseCase(name)
      emit(StateView.Success(burgers))

    } catch (e: HttpException) {
      e.printStackTrace()
      val error = e.getErrorResponse<ErrorResponse>()
      emit(StateView.Error(error?.message))

    } catch (e: Exception) {
      e.printStackTrace()
      emit(StateView.Error(e.message))
    }
  }
}