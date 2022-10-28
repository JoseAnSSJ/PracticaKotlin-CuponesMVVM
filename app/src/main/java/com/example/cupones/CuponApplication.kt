package com.example.cupones

import android.app.Application
import androidx.room.Room
import com.example.cupones.common.dataAccess.CuponDataBase

class CuponApplication :Application() {
    companion object{
        lateinit var dataBase: CuponDataBase
    }

    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(this, CuponDataBase::class.java, "CuponDataBase").build()


    }
}