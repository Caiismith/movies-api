package com.cai.smith.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

public class Comment {

    @Field("user")
    @JsonProperty("user")
    private String user;

    @Field("message")
    @JsonProperty("message")
    private String message;

    @Field("dateCreated")
    @JsonProperty("dateCreated")
    private String dateCreated;

    @Field("like")
    @JsonProperty("like")
    private int like;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
