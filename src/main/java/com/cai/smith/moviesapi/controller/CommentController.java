package com.cai.smith.moviesapi.controller;

import com.cai.smith.moviesapi.model.Comment;
import com.cai.smith.moviesapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping()
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/most-active")
    public List<Comment> getMostActive() {

        List<Comment> comments = commentRepository.findAll();
        ArrayList<String> users = new ArrayList<>();

        for (Comment comment: comments) {
            users.add(comment.getUser());
        }

        Map<String, Long> occurrences =
                users.stream().collect(
                        Collectors.groupingBy(w -> w, Collectors.counting()));

        String mostPopular = occurrences.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

        return commentRepository.findAllByUser(mostPopular);
    }
}
