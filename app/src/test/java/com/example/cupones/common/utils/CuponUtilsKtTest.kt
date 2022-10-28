package com.example.cupones.common.utils

import org.junit.Assert.*
import org.junit.Test
import com.example.cupones.R
import com.example.cupones.common.entitys.CuponEntity

class CuponUtilsKtTest{
    @Test
    fun validadTextCodeSuccessTest(){
        val code = "Welcome"
        assertTrue(validadTextCode(code))
    }

    @Test
    fun validadTextCodeEmptyTest(){
        val code = ""
        assertFalse(validadTextCode(code))
    }

    @Test
    fun validadTextCodeMinLenghTest(){
        val code = "Hola"
        val code2 = "Hola2"
        assertFalse(validadTextCode(code))
        assertTrue(validadTextCode(code2))
    }

    @Test
    fun validadTextCodeMaxLenghTest(){
        val code = "HolaComoEstasHoy"
        val code2 = "Hola2"
        assertFalse(validadTextCode(code))
        assertTrue(validadTextCode(code2))
    }

    @Test
    fun getMsgErrorByCodeNullTest(){
        val errorCode = null
        val expectedValue = R.string.error_unknow
        val result = getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar un cupon null",expectedValue,result)
    }

    @Test
    fun getMsgErrorByCodeExistTest(){
        val errorCode = Constans.ERROR_EXIST
        val expectedValue = R.string.error_invalid_exist
        val result = getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar un cupon existente",expectedValue,result)
    }

    @Test
    fun getMsgErrorByCodeLengthTest(){
        val errorCode = Constans.ERROR_LENGTH
        val expectedValue = R.string.error_invalid_long
        val result = getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar un cupon longitud",expectedValue,result)
        assertNotEquals("El recuerso no existe",-1,result)
    }

    @Test
    fun checkNotNullCuponTest(){
        val cupon = CuponEntity(
            code= "andorid",
            descripcion = "cursos"
        )

        assertNotNull("El cupon no debe ser null", cupon)
    }

    @Test
    fun checkGroupsSuccessTest(){
        val aName = arrayOf(
            "Hola", "Como", "Estas"
        )
        val bName = arrayOf(
            "Hola", "Como", "Estas"
        )

        assertArrayEquals("Los arreglos deberian conicidir", aName,bName)
    }

    @Test
    fun checkGroupFailTest(){
        val aName = arrayOf(
            "Hola", "Como", "Estas"
        )
        val bName = arrayOf(
            "Hola1", "Como", "Estas"
        )

        assertNotEquals("Los arreglos no deberian conicidir", aName,bName)
    }
}