package br.com.lzacheu.appflix.movies;

/**
 * Created by luiszacheu on 22/06/18.
 */
public class MoviesPresenter implements MoviesContract.Presenter {

    MoviesContract.View moviesView;

    public MoviesPresenter(MoviesContract.View moviesView) {
        this.moviesView = moviesView;
    }

    @Override
    public void loadMovies() {

    }

    @Override
    public void retryLoadMovies() {

    }

    @Override
    public void start() {
        moviesView.showLoading(true);
    }
}
