package br.com.lzacheu.appflix.data;

import br.com.lzacheu.appflix.data.network.MovieService;
import br.com.lzacheu.appflix.data.network.NetworkFactory;
import br.com.lzacheu.appflix.data.network.RemoteCallback;
import br.com.lzacheu.appflix.data.network.model.MovieResponse;

/**
 * Created by luiszacheu on 03/07/18.
 */
public class DataManager {

    private static DataManager instance;

    private final MovieService movieService;

    public static DataManager getInstance(){
        if (instance == null){
            instance = new DataManager();
        }

        return instance;
    }

    private DataManager(){
        movieService = NetworkFactory.makeMovieService();
    }

    public void getMovies(RemoteCallback<MovieResponse> listener){
        movieService.getMoviesUpcoming(NetworkFactory.API_KEY, NetworkFactory.LANGUAGE_DEFAULT)
                .enqueue(listener);
    }

}
