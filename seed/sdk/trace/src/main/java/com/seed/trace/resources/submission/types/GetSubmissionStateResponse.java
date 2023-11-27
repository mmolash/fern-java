/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.submission.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import com.seed.trace.resources.commons.types.Language;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetSubmissionStateResponse.Builder.class)
public final class GetSubmissionStateResponse {
    private final Optional<OffsetDateTime> timeSubmitted;

    private final String submission;

    private final Language language;

    private final SubmissionTypeState submissionTypeState;

    private final Map<String, Object> additionalProperties;

    private GetSubmissionStateResponse(
            Optional<OffsetDateTime> timeSubmitted,
            String submission,
            Language language,
            SubmissionTypeState submissionTypeState,
            Map<String, Object> additionalProperties) {
        this.timeSubmitted = timeSubmitted;
        this.submission = submission;
        this.language = language;
        this.submissionTypeState = submissionTypeState;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("timeSubmitted")
    public Optional<OffsetDateTime> getTimeSubmitted() {
        return timeSubmitted;
    }

    @JsonProperty("submission")
    public String getSubmission() {
        return submission;
    }

    @JsonProperty("language")
    public Language getLanguage() {
        return language;
    }

    @JsonProperty("submissionTypeState")
    public SubmissionTypeState getSubmissionTypeState() {
        return submissionTypeState;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetSubmissionStateResponse && equalTo((GetSubmissionStateResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetSubmissionStateResponse other) {
        return timeSubmitted.equals(other.timeSubmitted)
                && submission.equals(other.submission)
                && language.equals(other.language)
                && submissionTypeState.equals(other.submissionTypeState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.timeSubmitted, this.submission, this.language, this.submissionTypeState);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SubmissionStage builder() {
        return new Builder();
    }

    public interface SubmissionStage {
        LanguageStage submission(String submission);

        Builder from(GetSubmissionStateResponse other);
    }

    public interface LanguageStage {
        SubmissionTypeStateStage language(Language language);
    }

    public interface SubmissionTypeStateStage {
        _FinalStage submissionTypeState(SubmissionTypeState submissionTypeState);
    }

    public interface _FinalStage {
        GetSubmissionStateResponse build();

        _FinalStage timeSubmitted(Optional<OffsetDateTime> timeSubmitted);

        _FinalStage timeSubmitted(OffsetDateTime timeSubmitted);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SubmissionStage, LanguageStage, SubmissionTypeStateStage, _FinalStage {
        private String submission;

        private Language language;

        private SubmissionTypeState submissionTypeState;

        private Optional<OffsetDateTime> timeSubmitted = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(GetSubmissionStateResponse other) {
            timeSubmitted(other.getTimeSubmitted());
            submission(other.getSubmission());
            language(other.getLanguage());
            submissionTypeState(other.getSubmissionTypeState());
            return this;
        }

        @Override
        @JsonSetter("submission")
        public LanguageStage submission(String submission) {
            this.submission = submission;
            return this;
        }

        @Override
        @JsonSetter("language")
        public SubmissionTypeStateStage language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        @JsonSetter("submissionTypeState")
        public _FinalStage submissionTypeState(SubmissionTypeState submissionTypeState) {
            this.submissionTypeState = submissionTypeState;
            return this;
        }

        @Override
        public _FinalStage timeSubmitted(OffsetDateTime timeSubmitted) {
            this.timeSubmitted = Optional.of(timeSubmitted);
            return this;
        }

        @Override
        @JsonSetter(value = "timeSubmitted", nulls = Nulls.SKIP)
        public _FinalStage timeSubmitted(Optional<OffsetDateTime> timeSubmitted) {
            this.timeSubmitted = timeSubmitted;
            return this;
        }

        @Override
        public GetSubmissionStateResponse build() {
            return new GetSubmissionStateResponse(
                    timeSubmitted, submission, language, submissionTypeState, additionalProperties);
        }
    }
}