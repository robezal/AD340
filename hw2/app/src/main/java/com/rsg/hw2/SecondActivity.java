package com.rsg.hw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    private static final String TAG ="secondActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.reply);
        Intent intent = getIntent();
        String reply = intent.getStringExtra(MainActivity.reply);
        Log.i(TAG, "onCreate: reply"+reply);
        textView.setText(reply);
    }
}
