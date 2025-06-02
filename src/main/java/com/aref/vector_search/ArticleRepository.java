package com.aref.vector_search;

import org.springframework.data.domain.*;
import org.springframework.data.repository.Repository;

public interface ArticleRepository extends Repository<Integer, Article> {

    SearchResults<Article> searchTop10ByTitleAndEmbeddingNear(String title, Vector vector,
                                                                 Score scoreThreshold);

    SearchResults<Article> searchByTitleAndEmbeddingWithin(String title, Vector vector,
                                                              Range<Similarity> range, Limit topK);

}
