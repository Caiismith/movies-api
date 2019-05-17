package com.cai.smith.moviesapi.service;

import com.cai.smith.moviesapi.model.Movies;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Service
public class JsonReaderService {

    public Movies getMovies() throws IOException {
        JSONParser parser = new JSONParser();

        File file = ResourceUtils.getFile("classpath:movies.json");
        System.out.println("File Found : " + file.exists());

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(file, Movies.class);
    }
}
