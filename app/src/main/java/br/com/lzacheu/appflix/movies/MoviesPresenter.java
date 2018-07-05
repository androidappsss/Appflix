package br.com.lzacheu.appflix.movies;

import br.com.lzacheu.appflix.data.DataManager;
import br.com.lzacheu.appflix.data.network.RemoteCallback;
import br.com.lzacheu.appflix.data.network.model.MovieResponse;

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
