package com.cai.smith.moviesapi.repository;

import com.cai.smith.moviesapi.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllByUser(String user);

}
