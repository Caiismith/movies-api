package com.cai.smith.moviesapi;


import com.cai.smith.moviesapi.model.Movie;
import com.cai.smith.moviesapi.model.Movies;
import com.cai.smith.moviesapi.repository.MovieRepository;
import com.cai.smith.moviesapi.service.JsonReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApiApplication implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private JsonReaderService jsonReaderService;

    public static void main(String[] args) {
        SpringApplication.run(MoviesApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll();
        Movies movies = jsonReaderService.getMovies();

        for(Movie movie: movies.getMovies()) {
            movieRepository.save(movie);
        }
    }
}
