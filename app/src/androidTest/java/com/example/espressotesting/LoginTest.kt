package com.example.espressotesting

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.espressotesting.Pages.ListViewPage
import com.example.espressotesting.Pages.LoginPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {
    val loginPage = LoginPage()
    val listViewPage = ListViewPage()
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun login_With_Valid_Credentials() {
        loginPage.validate_login_screen_is_loaded()
        loginPage.click_and_type_username_as_email_address("pradap@espresso.com")
        loginPage.click_and_type_password_as_password("espresso_password")
        loginPage.click_on_login_button()
        listViewPage.validate_list_view_is_displayed()
    }

    @Test
    fun login_With_Invalid_Username_Credentials() {
        loginPage.validate_login_screen_is_loaded()
        loginPage.click_and_type_username_as_email_address("pradap@espresso.com")
        loginPage.click_and_type_password_as_password("Password1234!")
        loginPage.click_on_login_button()
        loginPage.validate_invalid_login_message_is_displayed()
    }

    @Test
    fun login_With_Invalid_Password_Credentials() {
        loginPage.validate_login_screen_is_loaded()
        loginPage.click_and_type_username_as_email_address("pradap.pandiyan@espresso.com")
        loginPage.click_and_type_password_as_password("espresso_password")
        loginPage.click_on_login_button()
        loginPage.validate_invalid_login_message_is_displayed()
    }
}
