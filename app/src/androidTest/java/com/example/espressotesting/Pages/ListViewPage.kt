package com.example.espressotesting.Pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.espressotesting.R

class ListViewPage () {
    private var listView = Espresso.onView(ViewMatchers.withId(R.id.lv_list))

    fun validate_list_view_is_displayed()
    {
        listView.check(matches(isDisplayed()));

    }
}