package com.wilk.tomasz.service.dtos;

import lombok.Builder;

@Builder(toBuilder = true)
public record PostDTO(Integer id, Integer userId, String title, String body) {
}
