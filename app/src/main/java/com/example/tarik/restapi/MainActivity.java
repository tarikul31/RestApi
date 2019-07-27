package com.example.tarik.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tarik.restapi.Activities.MovieActivity;
import com.example.tarik.restapi.Activities.MoviePostActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGetMovie,btnPostMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetMovie = findViewById(R.id.btnGetMovies);
        btnGetMovie.setOnClickListener(this);
        btnPostMovie = findViewById(R.id.btnPostMovies);
        btnPostMovie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v ==btnGetMovie){
            startActivity(new Intent(getApplicationContext(), MovieActivity.class));
        }
        if (v ==btnPostMovie){
            startActivity(new Intent(getApplicationContext(), MoviePostActivity.class));
        }

    }
}
