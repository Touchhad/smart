package com.example.autinfication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
ConstraintLayout constraintLayout;
    private final static String PHOTO_URL = "http://cinema.areas.su/up/images/";
    private final static String VIDEO_URL = "https://app.swaggerhub.com/up/video/";
    private List<Movie> mMovie;
    private Context mContext;

    public MovieAdapter(List<Movie> movies) {
        this.mMovie = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mMovie.get(position);
        Picasso.with(mContext)
                .load(PHOTO_URL + movie.getPoster())
                .into(holder.Image);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        });
        holder.Name.setText(movie.getName());
        holder.Description.setText(movie.getDescription());
    }

    @Override
    public int getItemCount() {
        if (mMovie == null) {
            return 0;
        }
        return mMovie.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView Name, Description, TagName;
        ImageView Image;
        VideoView videoView;

        ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linerLayout);
            Name = (TextView) itemView.findViewById(R.id.tvName);

            Description = (TextView) itemView.findViewById(R.id.tvDescription);
            TagName = (TextView) itemView.findViewById(R.id.tvTag);
            Image = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}