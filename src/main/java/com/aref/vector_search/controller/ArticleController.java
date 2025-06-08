package com.aref.vector_search.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aref.vector_search.model.ArticleCreateRequest;
import com.aref.vector_search.model.BaseResponse;
import com.aref.vector_search.service.ArticleService;

@RestController
@RequestMapping("api/v1/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    public ResponseEntity<BaseResponse> save(@RequestBody ArticleCreateRequest request) {
        articleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(BaseResponse.success());
    }
}
