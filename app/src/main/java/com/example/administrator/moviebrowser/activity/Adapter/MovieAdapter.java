package com.example.administrator.moviebrowser.activity.Adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.moviebrowser.R;
import com.example.administrator.moviebrowser.activity.Model.Movie;

import java.util.List;

import static com.example.administrator.moviebrowser.R.drawable.place_holder;

/**
 * Created by Administrator on 10/13/2016.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    public List<Movie> mMovies;
    public MovieAdapter(Context context, List<Movie> movies) {
        super(context, -1, movies);
        mMovies = movies;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Nullable
    @Override
    public Movie getItem(int position) {
        return mMovies.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_movie, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.ivCover = (ImageView) convertView.findViewById(R.id.ivCover);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvContent);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Movie movie = getItem(position);
        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        chooseConfig(movie, viewHolder);
        return convertView;
    }

    private void chooseConfig(Movie movie, ViewHolder viewHolder) {
        Configuration configuration = getContext().getResources()
                .getConfiguration();
        if (configuration.orientation == configuration.ORIENTATION_PORTRAIT) {
            Glide.with(getContext()).load(movie.getPosterPath())
                    .placeholder(place_holder)
                    .into(viewHolder.ivCover);
        } else {
            Glide.with(getContext()).load(movie.getBackdropPath())
                    .placeholder(place_holder)
                    .into(viewHolder.ivCover);
        }
    }

    private class ViewHolder{
        public TextView tvTitle;
        public TextView tvOverview;
        public ImageView ivCover;

    }
}

