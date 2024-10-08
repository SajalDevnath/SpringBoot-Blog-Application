package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       // - generates getters, setters, toString(), equals(), hashCode(), and a constructor for all final fields.
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY) // - signifies a many-to-one relationship, where many entities can be associated with a single instance of another entity.
    @JoinColumn(name = "post_id" , nullable = false)      // - Specifies a column for joining an entity association or element collection.
    private Post post;
}
