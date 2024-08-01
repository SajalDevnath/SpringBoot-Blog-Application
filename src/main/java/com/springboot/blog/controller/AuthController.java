package com.springboot.blog.controller;

import com.springboot.blog.payload.JwtAuthResponse;
import com.springboot.blog.payload.LoginDto;
import com.springboot.blog.payload.RegisterDto;
import com.springboot.blog.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(
        name = "CRUD REST APIs for Auth Resource"
)
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
            summary = "User Login",
            description = "This endpoint allows users to authenticate by providing login credentials. On successful authentication, a JWT (JSON Web Token) is generated and returned in the response, which can be used for subsequent requests to protected resources."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful login. Returns a JWT token in the response body."
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized. Invalid credentials provided."
    )
    // build login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @Operation(
            summary = "User Registration",
            description = "This endpoint allows new users to register by providing user details. Upon successful registration, a confirmation message is returned indicating that the user has been successfully created."
    )
    @ApiResponse(
            responseCode = "201",
            description = "User successfully registered. Returns a confirmation message."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Bad Request. The request contains invalid or missing data."
    )
    // build register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
