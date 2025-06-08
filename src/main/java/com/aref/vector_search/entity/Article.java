package com.aref.vector_search.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.domain.Vector;

@Table
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;


    private String content;

    @JdbcTypeCode(SqlTypes.VECTOR)
    @Array(length = 5)
    @Column(columnDefinition = "vector(384)") // pgvector
    private Vector embedding;

    public Article(String title, String content, Vector embedding) {
        this.title = title;
        this.content = content;
        this.embedding = embedding;
    }
}
