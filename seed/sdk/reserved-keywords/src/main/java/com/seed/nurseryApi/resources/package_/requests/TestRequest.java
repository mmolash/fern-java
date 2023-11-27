/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.nurseryApi.resources.package_.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.nurseryApi.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TestRequest.Builder.class)
public final class TestRequest {
    private final String for_;

    private final Map<String, Object> additionalProperties;

    private TestRequest(String for_, Map<String, Object> additionalProperties) {
        this.for_ = for_;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("for")
    public String getFor() {
        return for_;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TestRequest && equalTo((TestRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TestRequest other) {
        return for_.equals(other.for_);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.for_);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ForStage builder() {
        return new Builder();
    }

    public interface ForStage {
        _FinalStage for_(String for_);

        Builder from(TestRequest other);
    }

    public interface _FinalStage {
        TestRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ForStage, _FinalStage {
        private String for_;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(TestRequest other) {
            for_(other.getFor());
            return this;
        }

        @Override
        @JsonSetter("for")
        public _FinalStage for_(String for_) {
            this.for_ = for_;
            return this;
        }

        @Override
        public TestRequest build() {
            return new TestRequest(for_, additionalProperties);
        }
    }
}