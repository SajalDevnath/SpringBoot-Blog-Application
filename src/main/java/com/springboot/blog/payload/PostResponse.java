package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Response object containing a paginated list of posts along with pagination metadata."
)
public class PostResponse {
    private List<PostDto> content;

    @Schema(
            description = "Current page number in the paginated response.",
            example = "1"
    )
    private int pageNo;

    @Schema(
            description = "Number of items per page.",
            example = "10"
    )
    private int pageSize;

    @Schema(
            description = "Total number of elements across all pages.",
            example = "50"
    )
    private long totalElements;

    @Schema(
            description = "Total number of pages available.",
            example = "5"
    )
    private int totalPages;

    @Schema(
            description = "Indicates whether this is the last page.",
            example = "false"
    )
    private boolean last;
}
