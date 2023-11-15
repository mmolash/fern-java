/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.authEnvironmentVariables.resources.service;

import com.seed.authEnvironmentVariables.core.ApiError;
import com.seed.authEnvironmentVariables.core.ClientOptions;
import com.seed.authEnvironmentVariables.core.ObjectMappers;
import com.seed.authEnvironmentVariables.core.RequestOptions;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class ServiceClient {
    protected final ClientOptions clientOptions;

    public ServiceClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * GET request with custom api key
     */
    public String getWithApiKey(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("apiKey")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), String.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * GET request with custom api key
     */
    public String getWithApiKey() {
        return getWithApiKey(null);
    }
}
