package com.aref.vector_search;

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
    private Vector embedding;
}
