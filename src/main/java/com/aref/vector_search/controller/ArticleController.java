package com.aref.vector_search.controller;

import org.springframework.data.domain.SearchResults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aref.vector_search.entity.Article;
import com.aref.vector_search.model.ArticleCreateRequest;
import com.aref.vector_search.model.BaseResponse;
import com.aref.vector_search.service.ArticleService;

@RestController
@RequestMapping("api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody ArticleCreateRequest request) {
        articleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(BaseResponse.success());
    }

    @GetMapping("/search")
    public ResponseEntity<SearchResults<Article>> search(@RequestParam(name = "query", required = true) String query) {
        return ResponseEntity.ok().body(articleService.search(query));
    }
}
