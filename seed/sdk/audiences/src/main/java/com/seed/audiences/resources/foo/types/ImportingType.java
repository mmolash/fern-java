/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.audiences.resources.foo.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.audiences.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ImportingType.Builder.class)
public final class ImportingType {
    private final String imported;

    private final Map<String, Object> additionalProperties;

    private ImportingType(String imported, Map<String, Object> additionalProperties) {
        this.imported = imported;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("imported")
    public String getImported() {
        return imported;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ImportingType && equalTo((ImportingType) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ImportingType other) {
        return imported.equals(other.imported);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.imported);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ImportedStage builder() {
        return new Builder();
    }

    public interface ImportedStage {
        _FinalStage imported(String imported);

        Builder from(ImportingType other);
    }

    public interface _FinalStage {
        ImportingType build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ImportedStage, _FinalStage {
        private String imported;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ImportingType other) {
            imported(other.getImported());
            return this;
        }

        @Override
        @JsonSetter("imported")
        public _FinalStage imported(String imported) {
            this.imported = imported;
            return this;
        }

        @Override
        public ImportingType build() {
            return new ImportingType(imported, additionalProperties);
        }
    }
}
