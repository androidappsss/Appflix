package br.com.lzacheu.appflix.movies;

import android.util.Log;

import br.com.lzacheu.appflix.data.DataManager;
import br.com.lzacheu.appflix.data.network.RemoteCallback;
import br.com.lzacheu.appflix.data.network.model.MovieResponse;
import br.com.lzacheu.appflix.model.Movie;

/**
 * Created by luiszacheu on 22/06/18.
 */
public class MoviesPresenter implements MoviesContract.Presenter {

    private static final String TAG = MoviesPresenter.class.getSimpleName();
    private MoviesContract.View moviesView;
    private DataManager dataManager;

    public MoviesPresenter(MoviesContract.View moviesView) {
        this.moviesView = moviesView;
        dataManager =  DataManager.getInstance();
    }

    @Override
    public void loadMovies() {
        moviesView.showLoading(true);
        dataManager.getMovies(new RemoteCallback<MovieResponse>() {
            @Override
            public void onSuccess(MovieResponse response) {
                for (Movie movie : response.getMovies()){
                    Log.e(TAG, "onSuccess: " + movie.toString() );
                }
                moviesView.showLoading(false);
                moviesView.showMovies(response.getMovies());
            }

            @Override
            public void onFailure(Throwable throwable) {
                moviesView.showLoading(false);
            }

            @Override
            public void onUnauthorized() {
                moviesView.showLoading(false);
            }
        });

    }

    @Override
    public void retryLoadMovies() {

    }

    @Override
    public void start() {
        moviesView.showLoading(true);
        loadMovies();
    }
}
