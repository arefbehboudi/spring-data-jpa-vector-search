package com.aref.vector_search.service;

import java.util.List;

import org.springframework.data.domain.ScoringFunction;
import org.springframework.data.domain.SearchResults;
import org.springframework.data.domain.Similarity;
import org.springframework.data.domain.Vector;
import org.springframework.stereotype.Service;

import com.aref.vector_search.entity.Article;
import com.aref.vector_search.model.ArticleCreateRequest;
import com.aref.vector_search.repository.ArticleRepository;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final EmbeddingService embeddingService;

    public ArticleService(ArticleRepository articleRepository,
                        EmbeddingService embeddingService) {
        this.articleRepository = articleRepository;
        this.embeddingService = embeddingService;
    }

    public void save(ArticleCreateRequest request) {
        List<Double> embeddings = embeddingService.embedd(request.getTitle());
        Vector vector = Vector.of(embeddings);
        articleRepository.save(new Article(request.getTitle(), request.getContent(), vector));
    }

    public SearchResults<Article> search(String query) {
        List<Double> embedding = embeddingService.embedd(query);
        Vector vector = Vector.of(embedding);
        return articleRepository.searchByEmbeddingNear(vector, Similarity.of(0.8, ScoringFunction.cosine()));
    }
}
