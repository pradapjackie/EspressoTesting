package com.example.espressotesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import androidx.test.uiautomator.*
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


private const val BASIC_SAMPLE_PACKAGE = "com.example.espressotesting"
private const val LAUNCH_TIMEOUT = 5000L
 @RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class UIAutomatorTest {
    private lateinit var device: UiDevice

    @Before
    fun initialize_UI_Automator() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )

        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE).apply {
            // Clear out any previous instances
         }
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
    }


    @Test()
    fun login_With_Valid_Credentials()
    {
        val emailTextbox: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/email_textbox"))
        emailTextbox.setText("pradap@espresso.com")

        val passwordTextbox: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/password_textbox"))
        passwordTextbox.setText("espresso_password")

        val loginButton: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/login_button"))
        loginButton.click()

        val appItem: UiObject = device.findObject(UiSelector().className("android.widget.ListView").instance(0).childSelector(UiSelector().text("Sutomo")))
        assertEquals(true, appItem.exists());
     }

     @Test()
     fun login_With_Invalid_Username_Credentials()
     {
         val emailTextbox: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/email_textbox"))
         emailTextbox.setText("pradap@espresso.com")

         val passwordTextbox: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/password_textbox"))
         passwordTextbox.setText("password")

         val loginButton: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/login_button"))
         loginButton.click()

         val appItem: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/espresso_testing").text("username and password is incorrect"))
         assertEquals(true, appItem.exists());
     }

     @Test()
     fun login_With_Invalid_Password_Credentials()
     {
         val emailTextbox: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/email_textbox"))
         emailTextbox.setText("test.com")

         val passwordTextbox: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/password_textbox"))
         passwordTextbox.setText("espresso_password")

         val loginButton: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/login_button"))
         loginButton.click()

         val appItem: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/espresso_testing").text("username and password is incorrect"))
         assertEquals(true, appItem.exists());
     }
//
//     @Test()
//     fun scroll_the_list_View()
//     {
//         val emailTextbox: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/email_textbox"))
//         emailTextbox.setText("pradap@espresso.com")
//
//         val passwordTextbox: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/password_textbox"))
//         passwordTextbox.setText("espresso_password")
//
//         val loginButton: UiObject = device.findObject(UiSelector().resourceId(BASIC_SAMPLE_PACKAGE+":id/login_button"))
//          loginButton.click()
//
//         val appItem: UiObject = device.findObject(UiSelector().className("android.widget.ListView").instance(0).childSelector(UiSelector().text("Sutomo")))
//         assertEquals(true, appItem.exists());
//
//         val appView = UiScrollable(UiSelector().scrollable(true))
//         appView.scrollIntoView(UiSelector().text("Tan Malaka"))
//         val listElement: UiObject = device.findObject(UiSelector().className("android.widget.ListView").instance(0).childSelector(UiSelector().text("Sutomo")))
//         assertEquals(true, listElement.exists());
//
//
//     }


}