/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.unknownAsAny.resources.unknown.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.unknownAsAny.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = MyObject.Builder.class)
public final class MyObject {
    private final Object unknown;

    private final Map<String, Object> additionalProperties;

    private MyObject(Object unknown, Map<String, Object> additionalProperties) {
        this.unknown = unknown;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("unknown")
    public Object getUnknown() {
        return unknown;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MyObject && equalTo((MyObject) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(MyObject other) {
        return unknown.equals(other.unknown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unknown);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UnknownStage builder() {
        return new Builder();
    }

    public interface UnknownStage {
        _FinalStage unknown(Object unknown);

        Builder from(MyObject other);
    }

    public interface _FinalStage {
        MyObject build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UnknownStage, _FinalStage {
        private Object unknown;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(MyObject other) {
            unknown(other.getUnknown());
            return this;
        }

        @Override
        @JsonSetter("unknown")
        public _FinalStage unknown(Object unknown) {
            this.unknown = unknown;
            return this;
        }

        @Override
        public MyObject build() {
            return new MyObject(unknown, additionalProperties);
        }
    }
}
