package com.example.tarik.restapi.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tarik.restapi.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public TextView name, realname, team, firstappearance, createdby, publisher, imageurl, bio;

    public MovieViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.tvname);
        realname = itemView.findViewById(R.id.tvrealname);
        team = itemView.findViewById(R.id.tvteam);
        firstappearance = itemView.findViewById(R.id.tvfirstappearance);
        createdby = itemView.findViewById(R.id.tvcreatedby);
        publisher = itemView.findViewById(R.id.tvpublisher);
        // imageurl = (TextView) itemView.findViewById(R.id.tvimageurl);
        bio = itemView.findViewById(R.id.tvbio);


    }
}
