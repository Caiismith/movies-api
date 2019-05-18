package com.cai.smith.moviesapi;


import com.cai.smith.moviesapi.model.Comment;
import com.cai.smith.moviesapi.model.Movie;
import com.cai.smith.moviesapi.model.Movies;
import com.cai.smith.moviesapi.repository.CommentRepository;
import com.cai.smith.moviesapi.repository.MovieRepository;
import com.cai.smith.moviesapi.service.JsonReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MoviesApiApplication implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private JsonReaderService jsonReaderService;

    public static void main(String[] args) {
        SpringApplication.run(MoviesApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll();
        commentRepository.deleteAll();

        Movies movies = jsonReaderService.getMovies();

        for(Movie movie: movies.getMovies()) {
            List<Comment> comments =  movie.getComments();
            for(Comment comment : comments) {
                commentRepository.save(comment);
            }
            movieRepository.save(movie);
        }
    }
}
