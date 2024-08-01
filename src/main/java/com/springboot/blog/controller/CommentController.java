package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Tag(
        name = "CRUD REST APIs for Comment Resource"
)
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(
            summary = "Create Comment",
            description = "This endpoint allows users to create a comment for a specific post. The comment details are provided in the request body, and the comment is associated with the post identified by the `postId` path variable. On successful creation, the comment is saved to the database and returned in the response."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Comment successfully created. Returns the created comment in the response body."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Bad Request. Invalid comment data or request parameters."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found. The specified post ID does not exist."
    )
    // create comment by rest api
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId, @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Retrieve Comments for a Post",
            description = "Fetches all comments associated with a specific post identified by the given post ID. This endpoint returns a list of comments for the specified post from the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful retrieval of comments. Returns a list of comments for the specified post."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Post not found. The provided post ID does not match any existing posts."
    )
    // get all comments by postId rest api
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @Operation(
            summary = "Retrieve Comment by ID",
            description = "Fetches a specific comment associated with a particular post using its ID. This endpoint retrieves detailed information about the comment from the database based on the provided post ID and comment ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful retrieval of the comment. Returns the comment details in the response body."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Comment not found. The specified comment or post ID does not exist."
    )
    // get comment by Id rest api
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Comment by ID",
            description = "This endpoint allows users to update a specific comment associated with a particular post in the database. The user must provide the post ID, comment ID, and the updated comment data."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully updated the comment. Returns the updated comment data."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Post or Comment not found. Either the post ID or the comment ID does not exist."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Bad Request. The input data is invalid."
    )
    // update comment by Id rest api
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long commentId, @Valid @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Comment by Id REST API",
            description = "This endpoint allows users to delete a specific comment from a particular post in the database by providing the post ID and comment ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful deletion. Returns a confirmation message."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found. The specified comment or post does not exist."
    )
    // delete comment by Id rest api
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully!", HttpStatus.OK);
    }
}
