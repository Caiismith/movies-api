package com.cai.smith.moviesapi.service;

import com.cai.smith.moviesapi.model.Movie;
import com.cai.smith.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getHighestLikedMovie() {
        return movieRepository.findFirstByOrderByLikesDesc();
    }

    public Movie getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
