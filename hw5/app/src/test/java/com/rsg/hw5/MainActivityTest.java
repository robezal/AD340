package com.rsg.hw5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {


    @Test
    public void badInputTest(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        activity.findViewById(R.id.button).performClick();
        assertEquals("Check all inputs!", ShadowToast.getTextOfLatestToast());
    }
}
