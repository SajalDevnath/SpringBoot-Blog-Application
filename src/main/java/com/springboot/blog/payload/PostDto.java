package com.springboot.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;

    // Post title should not be empty or null
    // Post title should have at least 2 characters
    @NotEmpty       // - The annotated element must not be null nor empty.
    @Size(min = 2, message = "Post title should have at least 2 characters")        // - The annotated element size must be between the specified boundaries (included)
    private String title;

    // Post description should not be empty or null
    // Post description should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    // Post content should not be empty or null
    @NotEmpty
    private String content;

    private Set<CommentDto> comments;
}

