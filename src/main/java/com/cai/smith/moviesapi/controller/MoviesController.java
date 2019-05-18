package com.cai.smith.moviesapi.controller;

import com.cai.smith.moviesapi.model.Movie;
import com.cai.smith.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping()
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/most-liked")
    public Movie getHighestLikedMovie() {
        return movieRepository.findFirstByOrderByLikesDesc();
    }

    @GetMapping("/{title}")
    public Movie getMovieByTitle(@PathVariable String title) {
        return movieRepository.findByTitle(title);
    }
}
