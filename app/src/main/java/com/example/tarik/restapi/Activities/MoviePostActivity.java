package com.example.tarik.restapi.Activities;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarik.restapi.Config.ApiConfig;
import com.example.tarik.restapi.Model.Movies;
import com.example.tarik.restapi.Service.MovieService;
import com.example.tarik.restapi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePostActivity extends AppCompatActivity {
    private EditText nameEt, realnameEt, teamEt, realappereanceEt, createByEt;
    private String name, realname, team, realappereance, createBy;
    private Button btnPost;
    private MovieService movieService;
    private List<Movies> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_post);
        nameEt = findViewById(R.id.nameET);
        realnameEt = findViewById(R.id.realnameET);
        teamEt = findViewById(R.id.teamET);
        realappereanceEt = findViewById(R.id.firstapperenceET);
        createByEt = findViewById(R.id.createByET);

        btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postMovie();
            }
        });
    }

    private void postMovie() {
        name = nameEt.getText().toString();
        realname = realnameEt.getText().toString();
        team = teamEt.getText().toString();
        realappereance = realappereanceEt.getText().toString();
        createBy = createByEt.getText().toString();

        Movies movies = new Movies();
        movies.setName(name);
        movies.setRealname(realname);
        movies.setTeam(team);
        movies.setFirstappearance(realappereance);
        movies.setCreatedby(createBy);

        movieService = ApiConfig.getApiClient().create(MovieService.class);
        Call<List<Movies>> call = movieService.getModel();
        try {
            call.enqueue(new Callback<List<Movies>>() {
                @Override
                public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {

                    Toast.makeText(MoviePostActivity.this, "Success " + response.message(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<Movies>> call, Throwable t) {
                    Toast.makeText(MoviePostActivity.this, "failed " + t, Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
