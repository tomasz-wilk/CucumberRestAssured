package com.wilk.tomasz.service.endpoints;

import com.wilk.tomasz.service.dtos.PostDTO;
import io.restassured.response.Response;

public class PostEndpoint extends BaseEndpoint {

    private static final String POSTS_PATH = "posts/";
    private static final String POST_PATH = "posts/{postId}";
    private static final String POST_COMMENTS_PATH = "posts/{postId}/comments";

    public Response getPost(int postId) {
        return given()
                .get(POST_PATH, postId)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getPostComments(int postId) {
        return given()
                .get(POST_COMMENTS_PATH, postId)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response addPost(PostDTO post) {
        return given()
                .body(post)
                .post(POSTS_PATH)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response deletePost(int id) {
        return given()
                .delete(POST_PATH, id)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
