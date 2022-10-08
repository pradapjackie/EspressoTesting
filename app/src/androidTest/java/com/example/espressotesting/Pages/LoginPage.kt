package com.example.espressotesting.Pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.espressotesting.R

class LoginPage () {

    private var emailTextbox = Espresso.onView(withId(R.id.email_textbox))
    private var passwordTextbox = Espresso.onView(withId(R.id.password_textbox))
    private var loginButton = Espresso.onView(withId(R.id.login_button))
    private var titleLogin = Espresso.onView(withId(R.id.title_login))
    private var loginMessage = Espresso.onView(withId(R.id.espresso_testing))

    fun validate_login_screen_is_loaded() {
        emailTextbox.check(ViewAssertions.matches(isDisplayed()))
        passwordTextbox.check(ViewAssertions.matches(isDisplayed()))
        loginButton.check(ViewAssertions.matches(isDisplayed()))
        titleLogin.check(ViewAssertions.matches(isDisplayed()))
     }

    fun click_and_type_username_as_email_address(emailAddress : String)
    {
        emailTextbox.perform().perform(
            ViewActions.replaceText(emailAddress),
            ViewActions.closeSoftKeyboard()
        )
    }

    fun click_and_type_password_as_password(password : String)
    {
        passwordTextbox.perform().perform(
            ViewActions.replaceText(password),
            ViewActions.closeSoftKeyboard()
        )
    }

    fun click_on_login_button()
    {
        loginButton.perform().perform(ViewActions.click())
    }

    fun validate_invalid_login_message_is_displayed()
    {
        loginMessage.check(matches(withText("username and password is incorrect")));
    }

}