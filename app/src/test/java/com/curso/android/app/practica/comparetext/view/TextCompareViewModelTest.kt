package com.curso.android.app.practica.comparetext.view

import com.curso.android.app.practica.comparetext.model.textCompare
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@Suppress("DEPRECATION")
class TextCompareViewModelTest {

    // El ViewModel a probar
    private lateinit var viewModel: TextCompareViewModel

    // Mock del modelo (TextComparator)
    @Mock
    private lateinit var textComparator: textCompare

    @Before
    fun setUp() {
        // Inicializar los objetos Mockito
        MockitoAnnotations.initMocks(this)

        // Crear el ViewModel con el modelo mock
        viewModel = TextCompareViewModel()
    }

    @Test
    fun testCompareText_WhenTextsAreEqual() {
        // Configurar el comportamiento del modelo mock
        Mockito.`when`(textComparator.compareText("Hello", "Hello")).thenReturn("Los textos son iguales")

        // Llamar a la función del ViewModel que deseas probar
        val result = viewModel.compareText("Hello", "Hello")

        // Verificar que el resultado sea el esperado
        assert(result == "Los textos son iguales")
    }

    @Test
    fun testCompareText_WhenTextsAreNotEqual() {
        // Configurar el comportamiento del modelo mock
        Mockito.`when`(textComparator.compareText("Hello", "World")).thenReturn("Los textos no son iguales")

        // Llamar a la función del ViewModel que deseas probar
        val result = viewModel.compareText("Hello", "World")

        // Verificar que el resultado sea el esperado
        assert(result == "Los textos no son iguales")
    }
}