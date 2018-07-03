package br.com.lzacheu.appflix.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by luiszacheu on 22/06/18.
 */
public class Movie {

    private long id;

    private String title;

    @SerializedName("original_title")
    private String originalTitle;

    private String overview;

    public Movie() {
    }

    public Movie(long id, String title, String originalTitle, String overview) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.overview = overview;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
