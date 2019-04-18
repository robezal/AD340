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
        String reply = intent.getStringExtra("grab");
        Log.i(TAG, "onCreate: reply"+reply);
        textView.setText(reply);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy: SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop: SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause: SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume: SecondActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart: SecondActivity");
    }

}
