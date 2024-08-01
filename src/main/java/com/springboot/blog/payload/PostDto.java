package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Schema(
        description = "Data transfer object representing a blog post. Includes essential details such as title, description, content, and related comments."
)
public class PostDto {
    @Schema(
            description = "Unique identifier for the post. This is typically assigned by the database and should be provided by the backend.",
            example = "1"
    )
    private long id;

    @Schema(
            description = "The title of the post.",
            example = "My First Blog Post"
    )
    // Post title should not be empty or null
    // Post title should have at least 2 characters
    @NotEmpty       // - The annotated element must not be null nor empty.
    @Size(min = 2, message = "Post title should have at least 2 characters")        // - The annotated element size must be between the specified boundaries (included)
    private String title;

    @Schema(
            description = "The description of the post.",
            example = "This post covers the basics of setting up a Spring Boot application."
    )
    // Post description should not be empty or null
    // Post description should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    @Schema(
            description = "The content of the post.",
            example = "In this post, we will explore the essential features of Spring Boot..."
    )
    // Post content should not be empty or null
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

    @Schema(
            description = "The ID of the category to which the post belongs. This helps in organizing posts under specific categories.",
            example = "2"
    )
    private Long categoryId;
}

