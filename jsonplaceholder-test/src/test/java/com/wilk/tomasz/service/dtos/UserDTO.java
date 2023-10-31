package com.wilk.tomasz.service.dtos;

import lombok.Builder;

@Builder(toBuilder = true)
public record UserDTO(Integer id, String name, String username, String email) {
}
