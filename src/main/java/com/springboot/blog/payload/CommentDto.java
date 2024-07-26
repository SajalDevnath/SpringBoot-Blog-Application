package com.springboot.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private long id;

    // name should not be empty or null
    @NotEmpty(message = "Name should not be empty or null")
    private String name;

    // email should not be empty or null
    // email field validation
    @NotEmpty(message = "Email should not be empty or null")
    @Email      // - The string has to be a well-formed email address.
    private String email;

    // comment body should not be empty or null
    // comment body should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Comment body should have at least 10 characters")
    private String body;
}
