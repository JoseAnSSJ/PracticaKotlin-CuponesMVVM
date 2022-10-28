package com.example.cupones

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.cupones.mainModule.view.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun createCuponTest(){
        val etTextCupon = onView(withId(R.id.edtCupon))
        val btnConsult = onView(withId(R.id.btnConsult))
        val btnCreate = onView(withId(R.id.btnCreate))
        val etTextDescripcion = onView(withId(R.id.edtDescripcion))
        val tvTitle = onView(withId(R.id.tvTitle))
        val snackbar = onView(withId(com.google.android.material.R.id.snackbar_text))


        etTextCupon.check(matches(withText("")))
        etTextCupon.perform(click())

        etTextCupon.perform(replaceText("Hola3"))
        btnConsult.perform(click())
        btnCreate.check(matches(isDisplayed()))

        btnCreate.check(matches(isDisplayed()))

        etTextCupon.perform(replaceText("Hola3"))
        etTextDescripcion.perform(replaceText("HolaHolaHola"))

        btnCreate.perform(click())

        tvTitle.check(matches(withText("Bienvenido, ingrese su cupon y acontinuacion presione en consultar.")))

        snackbar.check(matches( withText("Cupon creado")))

    }

    @Test
    fun ConsultaCuponExistente(){
        val etTextCupon = onView(withId(R.id.edtCupon))
        val btnConsult = onView(withId(R.id.btnConsult))
        val btnCreate = onView(withId(R.id.btnCreate))

        etTextCupon.check(matches(withText("")))
        etTextCupon.perform(click())

        etTextCupon.perform(replaceText("Hola3"))
        btnConsult.perform(click())
        btnCreate.check(matches(not(isDisplayed())))
    }

    @Test
    fun createCuponDuplicateTest(){
        val etTextCupon = onView(withId(R.id.edtCupon))
        val btnConsult = onView(withId(R.id.btnConsult))
        val btnCreate = onView(withId(R.id.btnCreate))
        val etTextDescripcion = onView(withId(R.id.edtDescripcion))
        val tvTitle = onView(withId(R.id.tvTitle))
        val snackbar = onView(withId(com.google.android.material.R.id.snackbar_text))


        etTextCupon.perform(replaceText("11111"))
        btnConsult.perform(click())
        btnCreate.check(matches(isDisplayed()))

        etTextCupon.perform(replaceText("Hola3"))
        etTextDescripcion.perform(replaceText("HolaHolaHola"))

        btnCreate.perform(click())


        snackbar.check(matches( withText("Error cupon existe.")))

    }
}