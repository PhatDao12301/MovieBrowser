package com.example.administrator.moviebrowser.activity.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 10/13/2016.
 */

public class NowPlaying {

    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}

