package com.cai.smith.moviesapi.controller;

import com.cai.smith.moviesapi.model.Comment;
import com.cai.smith.moviesapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping()
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/most-active")
    public List<Comment> getMostActive() {
        return commentService.getMostActive();
    }
}
