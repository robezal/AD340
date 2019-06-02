package com.rsg.hw5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //array for spinner [car types]
    private String[] array = new String[]{"Car","suv","van"};

    private String carType;

    //create variables for views
    private Button button;
    private EditText carMileage;
    private EditText days;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //create references to the views
        button = findViewById(R.id.button);
        carMileage = findViewById(R.id.car_mileage_edittext);
        days = findViewById(R.id.days);
        spinner = findViewById(R.id.car_type_spinner);
        spinner.setAdapter(adapter);



        //create listeners for views
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int d = Integer.parseInt(days.getText().toString());
                    int cm = Integer.parseInt(carMileage.getText().toString());
                    Car car = new Car(cm, carType);

                    //create reference to textview with an ID of results
                    TextView textView = findViewById(R.id.results);

                    //set text RESULTS to textview
                    textView.setText("Vehicle Type: " + car.getType()
                            + "\n\nMileage: " + car.getMiles()
                            + "\n\nDays: " + d
                            + "\n\nPrice: " + car.calculator(d));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Check all inputs!", Toast.LENGTH_LONG).show();
                }

            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                carType = array[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}