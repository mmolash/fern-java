package com.seed.trace.resources.playlist.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReservedKeywordEnum {
    IS("is"),

    AS("as");

    private final String value;

    ReservedKeywordEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}