package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data // - generates getters, setters, toString(), equals(), hashCode(), and a constructor for all final fields.
@AllArgsConstructor // - automatically generates a constructor with parameters for all fields in the class.
@NoArgsConstructor // - generates a no-argument constructor for a class in Java.

@Entity // - Specifies that the class is an entity. This annotation is applied to the entity class.
@Table(name = "posts", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) }) // - Specifies the primary table for the annotated entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();        // - Used Set instead of List because it is a collection that contains no duplicate elements.
}

