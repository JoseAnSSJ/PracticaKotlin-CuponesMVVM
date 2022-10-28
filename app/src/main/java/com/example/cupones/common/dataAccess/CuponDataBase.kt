package com.example.cupones.common.dataAccess

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cupones.common.entitys.CuponEntity

@Database(entities = [CuponEntity::class], version = 1)

abstract class CuponDataBase :RoomDatabase(){
    abstract fun cuponDao(): CuponDao
}