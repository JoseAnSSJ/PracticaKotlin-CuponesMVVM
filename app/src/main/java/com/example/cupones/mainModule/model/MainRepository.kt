package com.example.cupones.mainModule.model

import com.example.cupones.common.entitys.CuponEntity
import com.example.cupones.common.utils.Constans
import com.example.cupones.common.utils.validadTextCode

class MainRepository {

    private val rommDataBase = RommDataBase()

    suspend fun consultCuponByCode(code: String) = rommDataBase.consultCopuonByCode(code)

    suspend fun saveCupon(cuponEntity: CuponEntity){
        if(validadTextCode(cuponEntity.code)){
            rommDataBase.saveCopon(cuponEntity)
        }else{
            throw Exception(Constans.ERROR_LENGTH)
        }
    }


}