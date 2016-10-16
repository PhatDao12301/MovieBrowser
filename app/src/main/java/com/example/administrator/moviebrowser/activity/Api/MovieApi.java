package com.example.administrator.moviebrowser.activity.Api;

import com.example.administrator.moviebrowser.activity.Model.NowPlaying;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 10/13/2016.
 */

public interface MovieApi {
    @GET("now_playing")
    Call<NowPlaying> getNowPlaying();


}
