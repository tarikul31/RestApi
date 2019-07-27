package com.example.tarik.restapi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tarik.restapi.Model.Movies;
import com.example.tarik.restapi.R;
import com.example.tarik.restapi.ViewHolder.MovieViewHolder;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    Context context;
    private List<Movies> moviesList;

    public MovieAdapter(Context context, List<Movies> moviesList) {

        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movies movies = moviesList.get(position);
        holder.name.setText(movies.getName());
        holder.realname.setText(movies.getRealname());
        holder.team.setText(movies.getTeam());
        holder.firstappearance.setText(movies.getFirstappearance());
        holder.createdby.setText(movies.getCreatedby());
        holder.publisher.setText(movies.getPublisher());
        //  holder.imageurl.setText(movies.getImageurl());
        holder.bio.setText(movies.getBio());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
