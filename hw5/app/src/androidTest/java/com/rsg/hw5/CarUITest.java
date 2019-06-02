package com.rsg.hw5;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CarUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCarPrice() {

        onView(withId(R.id.car_mileage_edittext)).perform(typeText("1"));
        onView(withId(R.id.days)).perform(typeText("1"));


        onView(withId(R.id.car_type_spinner))
                .perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Car")))
                .perform(click());


        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.results)).check(matches(withText("Vehicle Type: Car"
                + "\n\nMileage: 1"
                + "\n\nDays: 1"
                + "\n\nPrice: 12")));

    }
}





