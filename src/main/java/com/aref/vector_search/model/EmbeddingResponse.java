package com.aref.vector_search.model;

import java.util.List;

public class EmbeddingResponse {
    private List<List<Double>> embeddings;

    public List<List<Double>> getEmbeddings() {
        return embeddings;
    }

    public void setEmbeddings(List<List<Double>> embeddings) {
        this.embeddings = embeddings;
    }
}
