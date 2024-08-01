package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Data transfer object representing a category for a blog post."
)
public class CategoryDto {

    @Schema(
            description = "Unique identifier for the category.",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Name of the category. Should be descriptive and unique.",
            example = "Technology"
    )
    private String name;

    @Schema(
            description = "Description of the category. Provides additional details about the category.",
            example = "Posts related to technology, including software, gadgets, and trends."
    )
    private String description;
}

