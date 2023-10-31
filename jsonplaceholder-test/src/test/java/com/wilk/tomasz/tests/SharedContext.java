package com.wilk.tomasz.tests;

import com.wilk.tomasz.service.dtos.CommentDTO;
import com.wilk.tomasz.service.dtos.PostDTO;
import com.wilk.tomasz.service.dtos.UserDTO;
import io.restassured.response.Response;
import lombok.Data;

@Data
public class SharedContext {
    private Response response;
    private UserDTO user;
    private CommentDTO comment;
    private PostDTO post;
    private int userId;
    private int postId;
    private int commentId;
}
