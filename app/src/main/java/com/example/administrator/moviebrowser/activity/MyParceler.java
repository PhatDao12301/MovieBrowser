package com.example.administrator.moviebrowser.activity;

import com.example.administrator.moviebrowser.activity.Model.Movie;

import org.parceler.Parcel;

/**
 * Created by Administrator on 10/16/2016.
 */
@Parcel
public class MyParceler {

    public String title;

    public String overview;

    public String posterPath;

    public String backdropPath;

    public MyParceler() {}

    public MyParceler(String title, String overview, String posterPath, String backdropPath) {
        this.title = title;
        this.overview = overview;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }
    public MyParceler(Movie movie){
        this.title = movie.getTitle();
        this.overview = movie.getOverview();
        this.posterPath = movie.getPosterPath();
        this.backdropPath = movie.getBackdropPath();
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }
}
