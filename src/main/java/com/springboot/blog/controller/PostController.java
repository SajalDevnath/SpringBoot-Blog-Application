package com.springboot.blog.controller;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.util.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")       // - This is the BASE URL for the REST APIs
@Tag(
        name = "CRUD REST APIs for Post Resource"
)
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(
            summary = "Create a New Blog Post",
            description = "This endpoint allows an authenticated user with ADMIN role to create a new blog post. The post details are provided in the request body and are saved to the database. The API returns the created post along with a 201 Created status."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Post successfully created. Returns the created blog post in the response body."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Bad Request. Invalid input data or validation errors in the provided post details."
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden. User does not have the required ADMIN role to create a post."
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // create blog post rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Retrieve All Posts",
            description = "This endpoint retrieves a paginated list of all blog posts from the database. You can customize the results by specifying pagination parameters like page number, page size, sort field, and sort direction."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful retrieval of posts. Returns a list of posts in the response body."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Bad Request. Invalid or missing parameters."
    )
    // get all blog post rest api
    @GetMapping
    public PostResponse getAllPosts(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                    @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    @Operation(
            summary = "Retrieve Post by ID",
            description = "This endpoint retrieves a single blog post from the database based on the provided post ID. It returns the details of the requested post if found, otherwise an appropriate error message is provided."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful retrieval of the post. Returns the post details in the response body."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Post not found. The specified post ID does not exist in the database."
    )
    // get post by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<PostDto>(postService.getPostById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Update Post by ID",
            description = "Updates an existing post in the database identified by the specified ID. The request must include the updated post details in the request body. Only users with 'ADMIN' role are authorized to perform this action."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully updated the post. Returns the updated post details."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Post not found. The ID provided does not match any existing post."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Bad Request. The request body contains invalid data or does not meet validation criteria."
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // update post by id rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Post by ID",
            description = "This endpoint deletes a post identified by the provided ID from the database. It requires the user to be authenticated with the 'ADMIN' role. On successful deletion, a confirmation message is returned."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful deletion. Returns a confirmation message indicating that the post has been deleted."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found. The post with the specified ID does not exist."
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden. The user does not have the required permissions to delete the post."
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // delete post by id rest api
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<String>("Post is deleted successfully!", HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve Posts by Category",
            description = "Fetches a list of posts that belong to the specified category. Provide the category ID as a path variable to retrieve posts associated with that category."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful retrieval. Returns a list of posts in the specified category."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found. No posts found for the given category ID."
    )
    // build get post by category REST API
    // http://localhost:8080/api/posts/category/23 - example URL
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable("id") Long categoryId) {
        List<PostDto> postDtos = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(postDtos);
    }

}

