package com.rsg.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Buttom button = findviewbyid(R.id.btn_get_data);
        button.setonClickListener(this);

        results = findViewById(R.id.lbl_results);

    }
    @override
    public void onClick(View view){


    }
}
