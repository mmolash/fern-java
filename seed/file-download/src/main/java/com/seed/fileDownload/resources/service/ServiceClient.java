package com.seed.fileDownload.resources.service;

import com.seed.fileDownload.core.ApiError;
import com.seed.fileDownload.core.ClientOptions;
import com.seed.fileDownload.core.ObjectMappers;
import com.seed.fileDownload.core.RequestOptions;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ServiceClient {
    protected final ClientOptions clientOptions;

    public ServiceClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public InputStream downloadFile() {
        return downloadFile(null);
    }

    public InputStream downloadFile(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return _response.body().byteStream();
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}