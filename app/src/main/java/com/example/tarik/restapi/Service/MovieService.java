package com.example.tarik.restapi.Service;

import android.graphics.Movie;

import com.example.tarik.restapi.Model.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MovieService {

    String BASE_URL= "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Movies>> getModel();

    @POST("marvel")
    Call<List<Movie>> postMovieData();


}
