package com.valik98.security.api;

import java.io.Serializable;

public record AuthenticationResponse(
        String jwt
) implements Serializable { }
