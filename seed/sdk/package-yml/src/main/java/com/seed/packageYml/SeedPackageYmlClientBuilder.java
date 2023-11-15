/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.packageYml;

import com.seed.packageYml.core.ClientOptions;
import com.seed.packageYml.core.Environment;

public final class SeedPackageYmlClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment;

    public SeedPackageYmlClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public SeedPackageYmlClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new SeedPackageYmlClient(clientOptionsBuilder.build());
    }
}
