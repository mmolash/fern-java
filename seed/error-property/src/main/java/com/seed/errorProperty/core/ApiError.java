package com.seed.errorProperty.core;

public final class ApiError extends RuntimeException {
    private final int statusCode;

    private final Object body;

    public ApiError(int statusCode, Object body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int statusCode() {
        return this.statusCode;
    }

    public Object body() {
        return this.body;
    }

    @Override
    public String toString() {
        return "ApiError{" + "statusCode: " + statusCode + ", body: " + body + "}";
    }
}
