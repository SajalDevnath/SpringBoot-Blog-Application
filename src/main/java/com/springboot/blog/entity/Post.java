package com.springboot.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // - generates getters, setters, toString(), equals(), hashCode(), and a constructor for all final fields.
@AllArgsConstructor // - automatically generates a constructor with parameters for all fields in the class.
@NoArgsConstructor // - generates a no-argument constructor for a class in Java.

@Entity // - Specifies that the class is an entity. This annotation is applied to the entity class.
@Table(name = "posts", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) }) // - Specifies the primary table for the annotated entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;
}

