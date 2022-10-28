package com.example.cupones.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cupones.R
import com.example.cupones.common.entitys.CuponEntity
import com.example.cupones.common.utils.getMsgErrorByCode
import com.example.cupones.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel :ViewModel() {

    private val repository = MainRepository()


    val cupon = MutableLiveData(CuponEntity())


    private val hideKeyboard = MutableLiveData<Boolean>()
    fun getIsHidenKeyboard() = hideKeyboard

    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackBarMsg() = snackbarMsg


    fun consultCuponByCode(){
        cupon.value?.code?.let { code->
            viewModelScope.launch {
                hideKeyboard.value = true
                cupon.value = repository.consultCuponByCode(code) ?: CuponEntity(isActive = false)
            }
        }

    }

    fun saveCupon(){
        cupon.value?.let { cuponEntity ->
            viewModelScope.launch {
                hideKeyboard.value = true
                try {
                    cuponEntity.isActive = true
                    repository.saveCupon(cuponEntity)
                    consultCuponByCode()
                    snackbarMsg.value = R.string.main_save_success
                }catch (e: Exception){
                    snackbarMsg.value = getMsgErrorByCode(e.message)

                }
            }
        }
    }

}