package br.com.lzacheu.appflix.movies;

import java.util.List;

import br.com.lzacheu.appflix.base.BasePresenter;
import br.com.lzacheu.appflix.base.BaseView;
import br.com.lzacheu.appflix.model.ConfigurationTmdb;
import br.com.lzacheu.appflix.model.Movie;

/**
 * Created by luiszacheu on 22/06/18.
 */
public interface MoviesContract {

    interface View extends BaseView<Presenter>{

        void showLoading(boolean active);

        void showMovies(List<Movie> movies);

        void showEmptyView(boolean active);

    }

    interface Presenter extends BasePresenter{

        void loadMovies();

        void retryLoadMovies();

    }
}
