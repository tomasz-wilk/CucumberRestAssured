package com.wilk.tomasz.service.endpoints;

import io.restassured.response.Response;

public class UserEndpoint extends BaseEndpoint {

    private static final String USER_PATH = "users/{userId}";
    private static final String USER_POSTS_PATH = "users/{userId}/posts";

    public Response getUser(int userId) {
        return given()
                .get(USER_PATH, userId)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getUserPosts(int userId) {
        return given()
                .get(USER_POSTS_PATH, userId)
                .then()
                .log().all()
                .extract()
                .response();
    }
}