package com.example.espressotesting

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var username_Textbox = findViewById(R.id.email_textbox) as EditText
        var password_Textbox = findViewById(R.id.password_textbox) as EditText
        var login_Button = findViewById(R.id.login_button) as Button
        var validation_Textview =findViewById(R.id.espresso_testing) as TextView



        login_Button.setOnClickListener {
            val userName = username_Textbox.text.toString();
            val password = password_Textbox.text.toString();

             if (userName == "pradap@espresso.com" && password == "espresso_password") {

                Toast.makeText(this, "Valid Login attempted", Toast.LENGTH_SHORT).show();
                 it.hideKeyboard()
                 validation_Textview.text = "Happy Espresso Testing"

                 val intent = Intent(this, Dashboard::class.java)
                  startActivity(intent)
             }else
            {
                validation_Textview.text = "username and password is incorrect"

                it.hideKeyboard()

            }
         }
    }
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

}