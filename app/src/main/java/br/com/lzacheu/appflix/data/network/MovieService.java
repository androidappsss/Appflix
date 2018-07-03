package br.com.lzacheu.appflix.data.network;

import br.com.lzacheu.appflix.data.network.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by luiszacheu on 03/07/18.
 */
public interface MovieService {

    @GET("3/movie/upcoming")
    Call<MovieResponse> getMoviesUpcoming(@Query("api_key") String apiKey,
                                          @Query("language") String language);

}
