package com.example.burgershub.presenter.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.burgershub.data.model.ErrorResponse
import com.example.burgershub.domain.usecase.GetBurgersByIdUseCase
import com.example.burgershub.util.StateView
import com.example.burgershub.util.getErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
  private val getBurgersByIdUseCase: GetBurgersByIdUseCase
) : ViewModel() {

  fun getBurgerById(burgerId: Int) = liveData(Dispatchers.IO) {
    try {
      emit(StateView.Loading())
      val burger = getBurgersByIdUseCase.invoke((burgerId))
      emit(StateView.Success(burger))

    } catch (e: HttpException) {
      val error = e.getErrorResponse<ErrorResponse>()
      emit(StateView.Error(error?.message))

    } catch (e: Exception) {
      e.printStackTrace()
      emit(StateView.Error(e.message))
    }
  }
}