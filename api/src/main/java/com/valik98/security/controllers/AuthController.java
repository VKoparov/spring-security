package com.valik98.security.controllers;

import com.valik98.security.api.AuthenticationRequest;
import com.valik98.security.api.AuthenticationResponse;
import com.valik98.security.api.UserCreateRequest;
import com.valik98.security.mappers.UserMapper;
import com.valik98.security.model.UserModel;
import com.valik98.security.services.UserService;
import com.valik98.security.utils.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        String jwt = jwtTokenProvider.generateJwt(authenticate);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserCreateRequest request) {
        SecurityContextHolder.clearContext();

        UserModel response = userService.register(userMapper.toUserModel(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toUserResponse(response));
    }
}
