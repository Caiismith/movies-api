package com.cai.smith.moviesapi.service;

import com.cai.smith.moviesapi.model.Comment;
import com.cai.smith.moviesapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getMostActive() {

        List<Comment> comments = commentRepository.findAll();
        ArrayList<String> users = new ArrayList<>();

        for (Comment comment: comments) {
            users.add(comment.getUser());
        }

        Map<String, Long> occurrences =
                users.stream().collect(
                        Collectors.groupingBy(w -> w, Collectors.counting()));

        String mostActive = occurrences.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

        return commentRepository.findAllByUser(mostActive);
    }
}
