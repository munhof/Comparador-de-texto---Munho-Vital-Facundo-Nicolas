package com.curso.android.app.practica.comparetext.model

import org.junit.Assert.assertEquals
import org.junit.Test

class textComparatorTest {

    @Test
    fun testCompareText_WhenTextsAreEqual() {
        val text1 = "Hello"
        val text2 = "Hello"

        val result = textCompare().compareText(text1, text2)

        assertEquals("Los textos son iguales", result)
    }

    @Test
    fun testCompareText_WhenTextsAreNotEqual() {
        val text1 = "Hello"
        val text2 = "World"

        val result = textCompare().compareText(text1, text2)

        assertEquals("Los textos no son iguales", result)
    }

    @Test
    fun testCompareText_WhenTextsAreNotEqualCaseSensitive() {
        val text1 = "Hello"
        val text2 = "hello"

        val result = textCompare().compareText(text1, text2)

        assertEquals("Los textos no son iguales", result)
    }

    @Test
    fun testCompareText_WhenNoTextWrite() {
        val text1 = ""
        val text2 = ""

        val result = textCompare().compareText(text1, text2)

        assertEquals("Los textos son iguales", result)
    }

    @Test
    fun testCompareText_WhenOnlyOneTextIsWrite() {
        val text1 = "Hello"
        val text2 = ""

        val result = textCompare().compareText(text1, text2)

        assertEquals("Los textos no son iguales", result)
    }
}