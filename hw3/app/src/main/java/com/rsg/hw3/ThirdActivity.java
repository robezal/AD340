package com.rsg.hw3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView movie, year, director, url, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        movie = findViewById(R.id.movie);
        year = findViewById(R.id.year);
        director = findViewById(R.id.director);
        url = findViewById(R.id.url);
        description = findViewById(R.id.description);

        Intent intent = getIntent();
        movie.setText(intent.getStringExtra("movie"));
        year.setText(intent.getStringExtra("year"));
        director.setText(intent.getStringExtra("director"));
        url.setText(intent.getStringExtra("url"));
        description.setText(intent.getStringExtra("description"));



    }
}
