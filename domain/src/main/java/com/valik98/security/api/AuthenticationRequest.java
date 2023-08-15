package com.valik98.security.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record AuthenticationRequest(
        @NotBlank
        @NotNull
        String username,
        @NotBlank
        @NotNull
        String password
) implements Serializable { }
