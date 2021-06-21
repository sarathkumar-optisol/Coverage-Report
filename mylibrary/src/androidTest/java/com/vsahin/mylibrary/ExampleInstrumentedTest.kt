package com.vsahin.mylibrary

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var stringToBetyped: String

    @get:Rule
    var activityRule: ActivityScenarioRule<MyLibraryActivity> =
        ActivityScenarioRule(MyLibraryActivity::class.java)

    @Before
    fun initValidString() {
        stringToBetyped = "Library"
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.vsahin.mylibrary", appContext.packageName)
    }

    @Test
    fun changeText_sameActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.editText))
            .perform(ViewActions.typeText(stringToBetyped), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText(stringToBetyped)))
    }
}