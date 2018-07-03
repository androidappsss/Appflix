package br.com.lzacheu.appflix.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.lzacheu.appflix.model.Movie;

/**
 * Created by luiszacheu on 03/07/18.
 */
public class MovieResponse {

    @SerializedName("results")
    private List<Movie> movies;

    public MovieResponse() {
    }

    public MovieResponse(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
