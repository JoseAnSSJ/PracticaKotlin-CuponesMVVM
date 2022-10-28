package com.example.cupones.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import com.example.cupones.CuponApplication
import com.example.cupones.common.dataAccess.CuponDao
import com.example.cupones.common.entitys.CuponEntity
import com.example.cupones.common.utils.Constans
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RommDataBase {

    private val dao: CuponDao by lazy { CuponApplication.dataBase.cuponDao() }


    suspend fun consultCopuonByCode(code: String) = dao.consultCuponByCode(code)

    suspend fun saveCopon(cuponEntity: CuponEntity) = withContext(Dispatchers.IO){
        try {
            dao.addCupon(cuponEntity)
        } catch (e: Exception) {
            (e as? SQLiteConstraintException)?.let {
                throw Exception(Constans.ERROR_EXIST)
            }
            throw Exception(e.message ?: Constans.ERROR_UNKNOW)
        }
    }

}