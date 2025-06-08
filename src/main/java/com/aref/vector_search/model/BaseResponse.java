package com.aref.vector_search.model;

public class BaseResponse {

    private Boolean success;

    public BaseResponse(Boolean success) {
        this.success = success;
    }

    public static BaseResponse success() {
        return new BaseResponse(true);
    }
    
}
