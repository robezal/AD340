package com.rsg.hw5;
import android.content.Context;



public class Car {
    private int miles;
    private String type;

    public Car(Context context) {
        this.miles = 0;
        this.type = "Car";
    }

    public Car(int miles, String type) {
        this.miles = miles;
        this.type = type;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int calculator(int days){
        int price = 0;
        int base = miles;
        int dayCharge = days * 10;

        switch(type){
            case "Car":
                base *= 2;
                break;

            case "suv":
                base *= 3;
                break;

            case "van":
                base *= 4;
                break;
        }
        price = base + dayCharge;



        return price;

    }



}