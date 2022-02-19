package com.example.espressotesting.commonfunctions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class CommonFunctions {
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}