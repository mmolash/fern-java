/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.responseProperty.model.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.responseProperty.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = WithDocs.Builder.class)
public final class WithDocs implements IWithDocs {
    private final String docs;

    private WithDocs(String docs) {
        this.docs = docs;
    }

    @JsonProperty("docs")
    @Override
    public String getDocs() {
        return docs;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WithDocs && equalTo((WithDocs) other);
    }

    private boolean equalTo(WithDocs other) {
        return docs.equals(other.docs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.docs);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DocsStage builder() {
        return new Builder();
    }

    public interface DocsStage {
        _FinalStage docs(String docs);

        Builder from(WithDocs other);
    }

    public interface _FinalStage {
        WithDocs build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DocsStage, _FinalStage {
        private String docs;

        private Builder() {}

        @Override
        public Builder from(WithDocs other) {
            docs(other.getDocs());
            return this;
        }

        @Override
        @JsonSetter("docs")
        public _FinalStage docs(String docs) {
            this.docs = docs;
            return this;
        }

        @Override
        public WithDocs build() {
            return new WithDocs(docs);
        }
    }
}
