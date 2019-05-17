package com.cai.smith.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Movies {

    @JsonProperty("movies")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}