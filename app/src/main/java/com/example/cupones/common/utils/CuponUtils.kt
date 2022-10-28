package com.example.cupones.common.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.cupones.R

fun validadTextCode(code: String): Boolean{
    return !(code.length < 5 || code.length > 10)
}

fun getMsgErrorByCode(errorCode: String?): Int =
    when(errorCode){
        Constans.ERROR_EXIST -> R.string.error_invalid_exist
        Constans.ERROR_LENGTH -> R.string.error_invalid_long
        else -> R.string.error_unknow
    }

fun hidenKeybord(context: Context, view: View){
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}
