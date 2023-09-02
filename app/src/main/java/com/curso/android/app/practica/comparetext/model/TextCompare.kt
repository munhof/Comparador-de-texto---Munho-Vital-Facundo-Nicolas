package com.curso.android.app.practica.comparetext.model


class textCompare {
    fun compareText(text1: String, text2: String): String {
        return if (text1 == text2) {
            "Los textos son iguales"
        } else {
            "Los textos no son iguales"
        }
    }
}