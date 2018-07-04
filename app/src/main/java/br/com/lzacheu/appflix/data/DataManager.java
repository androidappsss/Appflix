package br.com.lzacheu.appflix.data;

        import br.com.lzacheu.appflix.data.network.TmdbService;
        import br.com.lzacheu.appflix.data.network.NetworkFactory;
        import br.com.lzacheu.appflix.data.network.RemoteCallback;
        import br.com.lzacheu.appflix.data.network.model.MovieResponse;
        import br.com.lzacheu.appflix.model.ConfigurationTmdb;

/**
 * Created by luiszacheu on 03/07/18.
 */
public class DataManager {

    private static DataManager instance;

    private final TmdbService tmdbService;

    public static DataManager getInstance(){
        if (instance == null){
            instance = new DataManager();
        }

        return instance;
    }

    private DataManager(){
        tmdbService = NetworkFactory.getApiService(TmdbService.class);
    }

    public void getMovies(RemoteCallback<MovieResponse> listener){
        tmdbService.getMoviesUpcoming(NetworkFactory.API_KEY, NetworkFactory.LANGUAGE_DEFAULT)
                .enqueue(listener);
    }

    public void getConfiguration(RemoteCallback<ConfigurationTmdb> listener){
        tmdbService.getConfiguration(NetworkFactory.API_KEY)
                .enqueue(listener);
    }

}
