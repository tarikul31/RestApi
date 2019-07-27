package com.example.tarik.restapi.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tarik.restapi.Adapter.MovieAdapter;
import com.example.tarik.restapi.Config.ApiConfig;
import com.example.tarik.restapi.Service.MovieService;
import com.example.tarik.restapi.Model.Movies;
import com.example.tarik.restapi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Movies> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        recyclerView = findViewById(R.id.recylerViewId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        moviesList = new ArrayList<>();
        MovieService movieService = ApiConfig.getApiClient().create(MovieService.class);
        Call<List<Movies>> call = movieService.getModel();

        call.enqueue(new Callback<List<Movies>>() {
            @Override
            public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {

                List<Movies> movies = response.body();
                MovieAdapter movieAdapter = new MovieAdapter(MovieActivity.this, movies);
                recyclerView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<List<Movies>> call, Throwable t) {

            }
        });

    }
}
