/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RootType.Builder.class)
public final class RootType implements IRootType {
    private final String s;

    private RootType(String s, Map<String, Object> additionalProperties) {
        this.s = s;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("s")
    @Override
    public String getS() {
        return s;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RootType && equalTo((RootType) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RootType other) {
        return s.equals(other.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.s);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SStage builder() {
        return new Builder();
    }

    public interface SStage {
        _FinalStage s(String s);

        Builder from(RootType other);
    }

    public interface _FinalStage {
        RootType build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SStage, _FinalStage {
        private String s;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(RootType other) {
            s(other.getS());
            return this;
        }

        @Override
        @JsonSetter("s")
        public _FinalStage s(String s) {
            this.s = s;
            return this;
        }

        @Override
        public RootType build() {
            return new RootType(s, additionalProperties);
        }
    }
}
