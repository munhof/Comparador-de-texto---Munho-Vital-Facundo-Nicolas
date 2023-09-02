package com.curso.android.app.practica.comparetext

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.idling.CountingIdlingResource
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.comparetext.view.MainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@Suppress("DEPRECATION")
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    // Declaración de IdlingResource
    private val idlingResource = CountingIdlingResource("idlingResource")

    @Before
    fun setUp() {
        // Registra el IdlingResource
        Espresso.registerIdlingResources(idlingResource)

        // Asegúrate de que la actividad se inicie antes de cada prueba
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testCompareTextButton() {
        // Simula la interacción con los EditText y el botón
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
            .perform(ViewActions.typeText("Hola"))

        Espresso.onView(ViewMatchers.withId(R.id.editText2))
            .perform(ViewActions.typeText("World"))

        Espresso.onView(ViewMatchers.withId(R.id.buttonCompare))
            .perform(ViewActions.click())

        // Incrementa el contador del IdlingResource
        idlingResource.increment()

        // Verifica el resultado en el TextView
        Espresso.onView(ViewMatchers.withId(R.id.textViewResult))
            .check(ViewAssertions.matches(ViewMatchers.withText("Los textos no son iguales")))

        // Decrementa el contador del IdlingResource
        idlingResource.decrement()
    }
}