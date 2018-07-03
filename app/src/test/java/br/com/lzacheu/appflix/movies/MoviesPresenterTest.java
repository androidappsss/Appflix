package br.com.lzacheu.appflix.movies;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import br.com.lzacheu.appflix.model.Movie;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

/**
 * Created by luiszacheu on 22/06/18.
 */
public class MoviesPresenterTest {

    private static List<Movie> MOVIES_LIST;
    private static Movie MOVIE;

    MoviesContract.Presenter moviesPresenter;

    @Mock
    MoviesContract.View moviesView;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        moviesPresenter = new MoviesPresenter(moviesView);

        MOVIE = new Movie();
        MOVIES_LIST = new ArrayList<>();
        MOVIES_LIST.add(MOVIE);
    }

    @Test
    public void shouldLoagingWhenStartPresenter(){
        moviesPresenter.start();
        verify(moviesView).showLoading(true);
    }

    @Test
    public void shouldLoadMoviesWhenStartPresenter(){
        moviesPresenter.loadMovies();

        verify(moviesView, only()).showMovies(MOVIES_LIST);
    }
}
