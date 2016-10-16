package com.example.administrator.moviebrowser.activity.Model;

import com.example.administrator.moviebrowser.activity.MyParceler;
import com.example.administrator.moviebrowser.activity.Utils.Constant;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 10/13/2016.
 */

public class Movie {

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdropPath;

    public Movie(MyParceler myParceler) {
        this.title = myParceler.getTitle();
        this.overview = myParceler.getOverview();
        this.posterPath = myParceler.getPosterPath();
        this.backdropPath = myParceler.getBackdropPath();
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return Constant.STATIC_BASE_URL + posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return Constant.STATIC_BASE_URL + backdropPath;
    }
}
