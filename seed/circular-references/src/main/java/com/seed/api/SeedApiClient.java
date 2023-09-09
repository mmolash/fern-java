package com.seed.api;

import com.seed.api.core.ClientOptions;

public class SeedApiClient {
    protected final ClientOptions clientOptions;

    public SeedApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public static SeedApiClientBuilder builder() {
        return new SeedApiClientBuilder();
    }
}