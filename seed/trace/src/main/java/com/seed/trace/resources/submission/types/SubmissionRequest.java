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

public final class SubmissionRequest {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private SubmissionRequest(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static SubmissionRequest initializeProblemRequest(InitializeProblemRequest value) {
        return new SubmissionRequest(new InitializeProblemRequestValue(value));
    }

    public static SubmissionRequest initializeWorkspaceRequest() {
        return new SubmissionRequest(new InitializeWorkspaceRequestValue());
    }

    public static SubmissionRequest submitV2(SubmitRequestV2 value) {
        return new SubmissionRequest(new SubmitV2Value(value));
    }

    public static SubmissionRequest workspaceSubmit(WorkspaceSubmitRequest value) {
        return new SubmissionRequest(new WorkspaceSubmitValue(value));
    }

    public static SubmissionRequest stop(StopRequest value) {
        return new SubmissionRequest(new StopValue(value));
    }

    public boolean isInitializeProblemRequest() {
        return value instanceof InitializeProblemRequestValue;
    }

    public boolean isInitializeWorkspaceRequest() {
        return value instanceof InitializeWorkspaceRequestValue;
    }

    public boolean isSubmitV2() {
        return value instanceof SubmitV2Value;
    }

    public boolean isWorkspaceSubmit() {
        return value instanceof WorkspaceSubmitValue;
    }

    public boolean isStop() {
        return value instanceof StopValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<InitializeProblemRequest> getInitializeProblemRequest() {
        if (isInitializeProblemRequest()) {
            return Optional.of(((InitializeProblemRequestValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<SubmitRequestV2> getSubmitV2() {
        if (isSubmitV2()) {
            return Optional.of(((SubmitV2Value) value).value);
        }
        return Optional.empty();
    }

    public Optional<WorkspaceSubmitRequest> getWorkspaceSubmit() {
        if (isWorkspaceSubmit()) {
            return Optional.of(((WorkspaceSubmitValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<StopRequest> getStop() {
        if (isStop()) {
            return Optional.of(((StopValue) value).value);
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
        T visitInitializeProblemRequest(InitializeProblemRequest initializeProblemRequest);

        T visitInitializeWorkspaceRequest();

        T visitSubmitV2(SubmitRequestV2 submitV2);

        T visitWorkspaceSubmit(WorkspaceSubmitRequest workspaceSubmit);

        T visitStop(StopRequest stop);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({
        @JsonSubTypes.Type(InitializeProblemRequestValue.class),
        @JsonSubTypes.Type(InitializeWorkspaceRequestValue.class),
        @JsonSubTypes.Type(SubmitV2Value.class),
        @JsonSubTypes.Type(WorkspaceSubmitValue.class),
        @JsonSubTypes.Type(StopValue.class)
    })
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("initializeProblemRequest")
    private static final class InitializeProblemRequestValue implements Value {
        @JsonUnwrapped
        private InitializeProblemRequest value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private InitializeProblemRequestValue() {}

        private InitializeProblemRequestValue(InitializeProblemRequest value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitInitializeProblemRequest(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof InitializeProblemRequestValue && equalTo((InitializeProblemRequestValue) other);
        }

        private boolean equalTo(InitializeProblemRequestValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "SubmissionRequest{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("initializeWorkspaceRequest")
    private static final class InitializeWorkspaceRequestValue implements Value {
        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private InitializeWorkspaceRequestValue() {}

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitInitializeWorkspaceRequest();
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof InitializeWorkspaceRequestValue;
        }

        @Override
        public String toString() {
            return "SubmissionRequest{" + "}";
        }
    }

    @JsonTypeName("submitV2")
    private static final class SubmitV2Value implements Value {
        @JsonUnwrapped
        private SubmitRequestV2 value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private SubmitV2Value() {}

        private SubmitV2Value(SubmitRequestV2 value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitSubmitV2(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof SubmitV2Value && equalTo((SubmitV2Value) other);
        }

        private boolean equalTo(SubmitV2Value other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "SubmissionRequest{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("workspaceSubmit")
    private static final class WorkspaceSubmitValue implements Value {
        @JsonUnwrapped
        private WorkspaceSubmitRequest value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private WorkspaceSubmitValue() {}

        private WorkspaceSubmitValue(WorkspaceSubmitRequest value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitWorkspaceSubmit(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof WorkspaceSubmitValue && equalTo((WorkspaceSubmitValue) other);
        }

        private boolean equalTo(WorkspaceSubmitValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "SubmissionRequest{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("stop")
    private static final class StopValue implements Value {
        @JsonUnwrapped
        private StopRequest value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private StopValue() {}

        private StopValue(StopRequest value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitStop(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof StopValue && equalTo((StopValue) other);
        }

        private boolean equalTo(StopValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "SubmissionRequest{" + "value: " + value + "}";
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
            return "SubmissionRequest{" + "type: " + type + ", value: " + value + "}";
        }
    }
}