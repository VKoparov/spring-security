package com.valik98.security.api;

import com.valik98.security.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UserCreateRequest(
        @NotBlank
        @NotNull
        String username,
        @NotBlank
        @NotNull
        String email,
        @NotBlank
        @NotNull
        String password,
        @NotEmpty
        Set<Role> roles
) {}
