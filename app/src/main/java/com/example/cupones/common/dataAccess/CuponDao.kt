package com.example.cupones.common.dataAccess

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cupones.common.entitys.CuponEntity

@Dao
interface CuponDao {

    @Query("SELECT * FROM CuponEntity WHERE code = :code")
    suspend fun consultCuponByCode(code: String): CuponEntity?

    @Insert
    suspend fun addCupon(codeEntity: CuponEntity): Long
}