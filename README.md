# SpringBoot Blog Application

## Overview

This SpringBoot Blog Application is designed to provide a platform for users to manage blog posts, comments, categories, and user authentication. The application supports full CRUD (Create, Read, Update, Delete) operations, along with pagination, sorting, and security features.

## High-Level Requirements

1. **Posts Management**
    - Create, Read, Update, and Delete Posts
    - Provide Pagination and Sorting Support

2. **Comments Management**
    - Create, Read, Update, and Delete Comments for Blog Posts

3. **Authentication and Authorization**
    - Register, Login, and Security

4. **Category Management**
    - Create, Read, Update, and Delete Categories

## Technology Stack

- **Java Platform:** Java 17+
- **Java Frameworks:** Spring Framework and its portfolio projects like Spring Boot, Spring Security, and Spring Data JPA
- **Token Based Authentication:** JWT (Json Web Token)
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA (You can use STS (Spring Tool Suite))
- **Server:** Tomcat embedded server
- **Database:** MySQL database
- **REST Client:** Postman
- **API Documentation:** SpringDoc
- **Cloud for Deployment:** AWS Cloud

## Features

### Posts Management
- **Create Post:** Allow users to create new blog posts.
- **Read Post:** Allow users to view blog posts with pagination and sorting options.
- **Update Post:** Allow users to edit existing blog posts.
- **Delete Post:** Allow users to delete blog posts.

### Comments Management
- **Create Comment:** Allow users to add comments to blog posts.
- **Read Comments:** Allow users to view comments on blog posts.
- **Update Comment:** Allow users to edit their comments.
- **Delete Comment:** Allow users to delete their comments.

### Authentication and Authorization
- **User Registration:** Allow users to create an account.
- **User Login:** Allow users to log in to their account.
- **Security:** Ensure that user data and blog content are secure using JWT for authentication.

### Category Management
- **Create Category:** Allow users to create new categories.
- **Read Categories:** Allow users to view categories.
- **Update Category:** Allow users to edit existing categories.
- **Delete Category:** Allow users to delete categories.

### API Documentation
- **SpringDoc:** Provides interactive API documentation for the application's REST APIs.
  
## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/SpringBoot-Blog-Application.git
    ```

2. Navigate to the project directory:
    ```bash
    cd SpringBoot-Blog-Application
    ```

3. Update `application.properties` with your database configuration.

4. Build and run the application:
    ```bash
    ./mvnw spring-boot:run
    ```
---

Thank you for checking out my SpringBoot Blog Application! I hope you find it useful. Happy coding!
