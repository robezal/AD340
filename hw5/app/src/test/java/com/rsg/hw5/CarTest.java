package com.rsg.hw5;


import android.content.Context;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;


@RunWith(RobolectricTestRunner.class)
@Config(manifest= Config.NONE)
public class CarTest {

    Car car;
    Car defaultCar;
    Context context;

    @Before
    public void setUp() throws Exception {
        this.car = new Car(3, "Car");
        context = RuntimeEnvironment.application.getApplicationContext();
        this.defaultCar = new Car(context);
    }

    @Test
    public void calculatorTest() {
        int carPrice = car.calculator(1);
        assertThat(carPrice, is(16));
        int carPrice2 = car.calculator(2);
        assertThat(carPrice2, is(not(3)));
    }

    @Test
    public void defaultCalculatorTest() {
        int carPrice = defaultCar.calculator(1);
        assertThat(carPrice, is(10));
        int carPrice2 = defaultCar.calculator(2);
        assertThat(carPrice2, is(not(3)));
    }
}

