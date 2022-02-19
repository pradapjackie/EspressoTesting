package com.example.espressotesting.screens

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.espressotesting.R

class Textbox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textbox)

        var plain_textbox = findViewById(R.id.plain_text_view) as EditText
        var login_Button = findViewById(R.id.text_box_button) as Button
        var validation_Textview =findViewById(R.id.plain_text_view_display) as TextView

        login_Button.setOnClickListener {
            it.hideKeyboard()
            val plainTexts = plain_textbox.text.toString();


            validation_Textview.text =  plainTexts

            }
        }


    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
    }
