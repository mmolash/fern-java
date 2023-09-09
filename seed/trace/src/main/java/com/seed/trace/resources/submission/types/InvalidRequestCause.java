package com.seed.trace.resources.submission.types;

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

public final class InvalidRequestCause {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private InvalidRequestCause(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static InvalidRequestCause submissionIdNotFound(SubmissionIdNotFound value) {
        return new InvalidRequestCause(new SubmissionIdNotFoundValue(value));
    }

    public static InvalidRequestCause customTestCasesUnsupported(CustomTestCasesUnsupported value) {
        return new InvalidRequestCause(new CustomTestCasesUnsupportedValue(value));
    }

    public static InvalidRequestCause unexpectedLanguage(UnexpectedLanguageError value) {
        return new InvalidRequestCause(new UnexpectedLanguageValue(value));
    }

    public boolean isSubmissionIdNotFound() {
        return value instanceof SubmissionIdNotFoundValue;
    }

    public boolean isCustomTestCasesUnsupported() {
        return value instanceof CustomTestCasesUnsupportedValue;
    }

    public boolean isUnexpectedLanguage() {
        return value instanceof UnexpectedLanguageValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<SubmissionIdNotFound> getSubmissionIdNotFound() {
        if (isSubmissionIdNotFound()) {
            return Optional.of(((SubmissionIdNotFoundValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<CustomTestCasesUnsupported> getCustomTestCasesUnsupported() {
        if (isCustomTestCasesUnsupported()) {
            return Optional.of(((CustomTestCasesUnsupportedValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<UnexpectedLanguageError> getUnexpectedLanguage() {
        if (isUnexpectedLanguage()) {
            return Optional.of(((UnexpectedLanguageValue) value).value);
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
        T visitSubmissionIdNotFound(SubmissionIdNotFound submissionIdNotFound);

        T visitCustomTestCasesUnsupported(CustomTestCasesUnsupported customTestCasesUnsupported);

        T visitUnexpectedLanguage(UnexpectedLanguageError unexpectedLanguage);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({
        @JsonSubTypes.Type(SubmissionIdNotFoundValue.class),
        @JsonSubTypes.Type(CustomTestCasesUnsupportedValue.class),
        @JsonSubTypes.Type(UnexpectedLanguageValue.class)
    })
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("submissionIdNotFound")
    private static final class SubmissionIdNotFoundValue implements Value {
        @JsonUnwrapped
        private SubmissionIdNotFound value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private SubmissionIdNotFoundValue() {}

        private SubmissionIdNotFoundValue(SubmissionIdNotFound value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitSubmissionIdNotFound(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof SubmissionIdNotFoundValue && equalTo((SubmissionIdNotFoundValue) other);
        }

        private boolean equalTo(SubmissionIdNotFoundValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "InvalidRequestCause{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("customTestCasesUnsupported")
    private static final class CustomTestCasesUnsupportedValue implements Value {
        @JsonUnwrapped
        private CustomTestCasesUnsupported value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private CustomTestCasesUnsupportedValue() {}

        private CustomTestCasesUnsupportedValue(CustomTestCasesUnsupported value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitCustomTestCasesUnsupported(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof CustomTestCasesUnsupportedValue && equalTo((CustomTestCasesUnsupportedValue) other);
        }

        private boolean equalTo(CustomTestCasesUnsupportedValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "InvalidRequestCause{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("unexpectedLanguage")
    private static final class UnexpectedLanguageValue implements Value {
        @JsonUnwrapped
        private UnexpectedLanguageError value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private UnexpectedLanguageValue() {}

        private UnexpectedLanguageValue(UnexpectedLanguageError value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitUnexpectedLanguage(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof UnexpectedLanguageValue && equalTo((UnexpectedLanguageValue) other);
        }

        private boolean equalTo(UnexpectedLanguageValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "InvalidRequestCause{" + "value: " + value + "}";
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
            return "InvalidRequestCause{" + "type: " + type + ", value: " + value + "}";
        }
    }
}