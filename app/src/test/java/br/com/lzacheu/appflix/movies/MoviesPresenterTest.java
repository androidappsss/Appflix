package br.com.lzacheu.appflix.movies;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import br.com.lzacheu.appflix.model.Movie;

import static org.mockito.Mockito.verify;

/**
 * Created by luiszacheu on 22/06/18.
 */
public class MoviesPresenterTest {

    private List<Movie> MOVIES_LIST;

    MoviesContract.Presenter moviesPresenter;

    @Mock
    MoviesContract.View moviesView;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        moviesPresenter = new MoviesPresenter(moviesView);

        MOVIES_LIST = new ArrayList<>(0);
    }

    @Test
    public void shouldLoagingWhenStartPresenter(){
        moviesPresenter.start();
        verify(moviesView).showLoading(true);
    }

    @Test
    public void shouldLoadMoviesWhenStartPresenter(){
        moviesPresenter.start();
        verify(moviesView).showMovies(MOVIES_LIST);
    }
}
