package com.wilk.tomasz.service.dtos;

import lombok.Builder;

@Builder(toBuilder = true)
public record CommentDTO(Integer id, Integer postId, String name, String email, String body) {
}