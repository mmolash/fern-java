/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.literal.resources.literal.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

public final class CreateOptionsResponse {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private CreateOptionsResponse(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static CreateOptionsResponse ok(Boolean value) {
        return new CreateOptionsResponse(new OkValue(value));
    }

    public static CreateOptionsResponse options(Options value) {
        return new CreateOptionsResponse(new OptionsValue(value));
    }

    public boolean isOk() {
        return value instanceof OkValue;
    }

    public boolean isOptions() {
        return value instanceof OptionsValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<Boolean> getOk() {
        if (isOk()) {
            return Optional.of(((OkValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Options> getOptions() {
        if (isOptions()) {
            return Optional.of(((OptionsValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitOk(Boolean ok);

        T visitOptions(Options options);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({@JsonSubTypes.Type(OkValue.class), @JsonSubTypes.Type(OptionsValue.class)})
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("ok")
    private static final class OkValue implements Value {
        @JsonProperty("value")
        private Boolean value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private OkValue(@JsonProperty("value") Boolean value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitOk(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof OkValue && equalTo((OkValue) other);
        }

        private boolean equalTo(OkValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "CreateOptionsResponse{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("options")
    private static final class OptionsValue implements Value {
        @JsonUnwrapped
        private Options value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private OptionsValue() {}

        private OptionsValue(Options value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitOptions(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof OptionsValue && equalTo((OptionsValue) other);
        }

        private boolean equalTo(OptionsValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "CreateOptionsResponse{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @JsonValue
        private Object value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private _UnknownValue(@JsonProperty("value") Object value) {}

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor._visitUnknown(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
        }

        private boolean equalTo(_UnknownValue other) {
            return type.equals(other.type) && value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.type, this.value);
        }

        @Override
        public String toString() {
            return "CreateOptionsResponse{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
