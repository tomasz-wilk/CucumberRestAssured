package com.wilk.tomasz.service.data;

import com.wilk.tomasz.service.dtos.CommentDTO;
import com.wilk.tomasz.service.dtos.PostDTO;

public class DataTemplates {


    public CommentDTO createComment(Integer postId, Boolean nameAvailable, Boolean emailAvailable, Boolean bodyAvailable) {
        return CommentDTO.builder()
                .postId(postId)
                .name(nameAvailable ? DataGenerator.generateRandomName() : null)
                .email(emailAvailable ? DataGenerator.generateRandomEmailAddress() : null)
                .body(bodyAvailable ? DataGenerator.generateRandomBody() : null)
                .build();
    }

    public CommentDTO createComment(Integer postId) {
        return createComment(postId, true, true, true);
    }

    public CommentDTO updateComment(CommentDTO commentDTO, Boolean nameAvailable, Boolean emailAvailable,
                                    Boolean bodyAvailable) {
        return commentDTO.toBuilder()
                .postId(commentDTO.postId())
                .name(nameAvailable ? DataGenerator.generateRandomName() : commentDTO.name())
                .email(emailAvailable ? DataGenerator.generateRandomEmailAddress() : commentDTO.email())
                .body(bodyAvailable ? DataGenerator.generateRandomBody() : commentDTO.body())
                .build();
    }

    public PostDTO createPost(Integer userId, Boolean titleAvailable, Boolean bodyAvailable) {
        return PostDTO.builder()
                .userId(userId)
                .title(titleAvailable ? DataGenerator.generateRandomName() : null)
                .body(bodyAvailable ? DataGenerator.generateRandomBody() : null)
                .build();
    }
}
