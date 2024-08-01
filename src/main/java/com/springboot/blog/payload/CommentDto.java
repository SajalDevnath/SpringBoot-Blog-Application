package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        description = "Data transfer object representing a comment on a post. Includes details such as the commenter's name, email, and comment body."
)
public class CommentDto {
    @Schema(
            description = "Unique identifier for the comment.",
            example = "1"
    )
    private long id;

    @Schema(
            description = "Name of the person who made the comment.",
            example = "John Doe"
    )
    // name should not be empty or null
    @NotEmpty(message = "Name should not be empty or null")
    private String name;

    @Schema(
            description = "Email address of the person who made the comment.",
            example = "john.doe@example.com"
    )
    // email should not be empty or null
    // email field validation
    @NotEmpty(message = "Email should not be empty or null")
    @Email      // - The string has to be a well-formed email address.
    private String email;

    @Schema(
            description = "Content of the comment.",
            example = "This is a great post! Thanks for sharing."
    )
    // comment body should not be empty or null
    // comment body should have at least 10 characters
    @NotEmpty(message = "Comment body should not be empty or null")
    @Size(min = 10, message = "Comment body should have at least 10 characters")
    private String body;
}
