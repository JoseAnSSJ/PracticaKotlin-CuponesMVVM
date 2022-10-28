package com.example.cupones.common.entitys

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "CuponEntity", indices = [Index(value = ["code"], unique = true)])
data class CuponEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var code: String = "",
    var descripcion: String = "",
    var isActive: Boolean = true
)
