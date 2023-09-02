package com.curso.android.app.practica.comparetext.view
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.comparetext.model.textCompare

class TextCompareViewModel : ViewModel() {
    private val textComparator = textCompare()

    fun compareText(text1: String, text2: String): String {
        return textComparator.compareText(text1, text2)
    }
}