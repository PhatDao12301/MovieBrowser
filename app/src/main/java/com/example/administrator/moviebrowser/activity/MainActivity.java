package com.example.administrator.moviebrowser.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.administrator.moviebrowser.R;
import com.example.administrator.moviebrowser.activity.Adapter.MovieAdapter;
import com.example.administrator.moviebrowser.activity.Api.MovieApi;
import com.example.administrator.moviebrowser.activity.Model.Movie;
import com.example.administrator.moviebrowser.activity.Model.NowPlaying;
import com.example.administrator.moviebrowser.activity.Utils.RetrofitUtils;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    private ListView lvMovie;
    private MovieApi mMovieApi;
    private List<Movie> movies;
    private ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = (ListView) findViewById(R.id.lvMovie);
        mMovieApi = RetrofitUtils.get(getString(R.string.api_key))
                .create(MovieApi.class);

        pbLoading = (ProgressBar) findViewById(R.id.pbLoading);


        if (savedInstanceState == null) {
            fetchMovie();
        } else {
            MyParceler rsMovie;
            ArrayList<Movie> lsMovie = new ArrayList<>();
            int size = savedInstanceState.getInt("size");
            Parcelable plMovie;
            for (int i = 0; i < size; i++) {
                plMovie = savedInstanceState.getParcelable("data" + i);
                rsMovie = Parcels.unwrap(plMovie);
                lsMovie.add(new Movie(rsMovie));
            }
            movies = lsMovie;
            handleRespond();
        }
    }

    private void fetchMovie() {
        mMovieApi.getNowPlaying().
                enqueue(new Callback<NowPlaying>() {
                    @Override
                    public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {
                        Log.d("Response", String.valueOf(response.isSuccessful()));
                        movies = response.body().getMovies();
                        handleRespond();
                    }

                    @Override
                    public void onFailure(Call<NowPlaying> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                    }
                });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        Parcelable plMovie;
        for (int i = 0; i < movies.size(); i++) {
            plMovie = Parcels.wrap(new MyParceler(movies.get(i)));
            savedInstanceState.putParcelable("data" + i, plMovie);
        }
        savedInstanceState.putInt("size", movies.size());
        super.onSaveInstanceState(savedInstanceState);

    }

    private void handleRespond() {
        lvMovie.setAdapter(new MovieAdapter(MainActivity.this, movies));
        pbLoading.setVisibility(GONE);

    }
}
