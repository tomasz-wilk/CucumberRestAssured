package com.wilk.tomasz.service.endpoints;

import io.restassured.response.Response;
import com.wilk.tomasz.service.dtos.CommentDTO;

public class CommentEndpoint extends BaseEndpoint {

    private static final String COMMENTS_PATH = "comments/";
    private static final String COMMENT_PATH = "comments/{commentId}";

    public Response addComment(CommentDTO comment) {
        return given()
                .body(comment)
                .post(COMMENTS_PATH)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response updateComment(int commentId, CommentDTO comment) {
        return given()
                .body(comment)
                .put(COMMENT_PATH, commentId)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getComment(int commentId) {
        return given()
                .get(COMMENT_PATH, commentId)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getCommentsForPost(int postId) {
        return given()
                .queryParam("postId", postId)
                .when()
                .get(COMMENTS_PATH)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
