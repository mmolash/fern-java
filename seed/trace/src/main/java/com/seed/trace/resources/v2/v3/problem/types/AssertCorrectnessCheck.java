package com.seed.trace.resources.v2.v3.problem.types;

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

public final class AssertCorrectnessCheck {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private AssertCorrectnessCheck(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static AssertCorrectnessCheck deepEquality(DeepEqualityCorrectnessCheck value) {
        return new AssertCorrectnessCheck(new DeepEqualityValue(value));
    }

    public static AssertCorrectnessCheck custom(VoidFunctionDefinitionThatTakesActualResult value) {
        return new AssertCorrectnessCheck(new CustomValue(value));
    }

    public boolean isDeepEquality() {
        return value instanceof DeepEqualityValue;
    }

    public boolean isCustom() {
        return value instanceof CustomValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<DeepEqualityCorrectnessCheck> getDeepEquality() {
        if (isDeepEquality()) {
            return Optional.of(((DeepEqualityValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<VoidFunctionDefinitionThatTakesActualResult> getCustom() {
        if (isCustom()) {
            return Optional.of(((CustomValue) value).value);
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
        T visitDeepEquality(DeepEqualityCorrectnessCheck deepEquality);

        T visitCustom(VoidFunctionDefinitionThatTakesActualResult custom);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({@JsonSubTypes.Type(DeepEqualityValue.class), @JsonSubTypes.Type(CustomValue.class)})
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("deepEquality")
    private static final class DeepEqualityValue implements Value {
        @JsonUnwrapped
        private DeepEqualityCorrectnessCheck value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private DeepEqualityValue() {}

        private DeepEqualityValue(DeepEqualityCorrectnessCheck value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitDeepEquality(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof DeepEqualityValue && equalTo((DeepEqualityValue) other);
        }

        private boolean equalTo(DeepEqualityValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "AssertCorrectnessCheck{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("custom")
    private static final class CustomValue implements Value {
        @JsonUnwrapped
        private VoidFunctionDefinitionThatTakesActualResult value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private CustomValue() {}

        private CustomValue(VoidFunctionDefinitionThatTakesActualResult value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitCustom(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof CustomValue && equalTo((CustomValue) other);
        }

        private boolean equalTo(CustomValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "AssertCorrectnessCheck{" + "value: " + value + "}";
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
            return "AssertCorrectnessCheck{" + "type: " + type + ", value: " + value + "}";
        }
    }
}