package com.aref.vector_search.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aref.vector_search.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    SearchResults<Article> searchTop10ByEmbeddingNear(Vector vector, Score scoreThreshold);

    SearchResults<Article> searchByEmbeddingWithin(Vector vector, Range<Similarity> range, Limit topK);

    SearchResults<Article> searchByEmbeddingNear(Vector vector, Similarity similarity);

}
