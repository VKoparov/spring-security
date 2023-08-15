package com.valik98.security.model;

import com.valik98.security.enums.Role;

import java.util.Set;

public record UserModel(
        String username,
        String email,
        String password,
        Set<Role> roles
) {
}
