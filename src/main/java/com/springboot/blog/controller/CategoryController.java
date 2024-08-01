package com.springboot.blog.controller;

import com.springboot.blog.payload.CategoryDto;
import com.springboot.blog.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(
        name = "CRUD REST APIs for Category Resource"
)
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Add New Category",
            description = "This endpoint allows an authenticated user with an ADMIN role to add a new category. The category information is provided in the request body and is saved to the database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Category successfully created"
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized. The user is not authenticated."
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden. The user does not have the required role (ADMIN)."
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // build add category REST API
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto savedCategory = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Category by ID",
            description = "This endpoint retrieves the details of a specific category by its ID. The category information is returned in the response body."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful retrieval of the category. Returns the category details in the response body."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Category not found. The specified ID does not correspond to any existing category."
    )
    // build get category REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId) {
        CategoryDto categoryDto = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    @Operation(
            summary = "Get All Categories",
            description = "Retrieve a list of all categories from the database. This endpoint returns a list of CategoryDto objects representing the available categories."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful retrieval of categories. Returns a list of CategoryDto objects."
    )
    // build get all category REST API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @Operation(
            summary = "Update Category",
            description = "This endpoint allows administrators to update an existing category in the database by providing the category ID and the updated category details."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful update. Returns the updated category details."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Bad Request. Invalid input data provided."
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized. Authentication credentials were missing or incorrect."
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden. The user does not have the necessary permissions to update the category."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found. The category with the specified ID does not exist."
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // build update category REST API
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("id") Long categoryId) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, categoryId));
    }

    @Operation(
            summary = "Delete Category",
            description = "Deletes a category based on the provided ID. Only users with the ADMIN role can perform this action."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful deletion. Returns a confirmation message."
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized. Authentication is required."
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden. User does not have the necessary permissions."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found. The category with the specified ID does not exist."
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // build delete category REST API
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully!");
    }
}
