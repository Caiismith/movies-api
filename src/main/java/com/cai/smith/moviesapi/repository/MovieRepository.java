package com.cai.smith.moviesapi.repository;

import com.cai.smith.moviesapi.model.Comment;
import com.cai.smith.moviesapi.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findByTitle(String title);

    Movie findFirstByOrderByLikesDesc();
}
