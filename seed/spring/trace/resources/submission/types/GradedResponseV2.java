/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.submission.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import resources.v2.problem.types.TestCaseId;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = GradedResponseV2.Builder.class
)
public final class GradedResponseV2 {
  private final SubmissionId submissionId;

  private final Map<TestCaseId, TestCaseGrade> testCases;

  private GradedResponseV2(SubmissionId submissionId, Map<TestCaseId, TestCaseGrade> testCases) {
    this.submissionId = submissionId;
    this.testCases = testCases;
  }

  @JsonProperty("submissionId")
  public SubmissionId getSubmissionId() {
    return submissionId;
  }

  @JsonProperty("testCases")
  public Map<TestCaseId, TestCaseGrade> getTestCases() {
    return testCases;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GradedResponseV2 && equalTo((GradedResponseV2) other);
  }

  private boolean equalTo(GradedResponseV2 other) {
    return submissionId.equals(other.submissionId) && testCases.equals(other.testCases);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.submissionId, this.testCases);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static SubmissionIdStage builder() {
    return new Builder();
  }

  public interface SubmissionIdStage {
    _FinalStage submissionId(SubmissionId submissionId);

    Builder from(GradedResponseV2 other);
  }

  public interface _FinalStage {
    GradedResponseV2 build();

    _FinalStage testCases(Map<TestCaseId, TestCaseGrade> testCases);

    _FinalStage putAllTestCases(Map<TestCaseId, TestCaseGrade> testCases);

    _FinalStage testCases(TestCaseId key, TestCaseGrade value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements SubmissionIdStage, _FinalStage {
    private SubmissionId submissionId;

    private Map<TestCaseId, TestCaseGrade> testCases = new LinkedHashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(GradedResponseV2 other) {
      submissionId(other.getSubmissionId());
      testCases(other.getTestCases());
      return this;
    }

    @Override
    @JsonSetter("submissionId")
    public _FinalStage submissionId(SubmissionId submissionId) {
      this.submissionId = submissionId;
      return this;
    }

    @Override
    public _FinalStage testCases(TestCaseId key, TestCaseGrade value) {
      this.testCases.put(key, value);
      return this;
    }

    @Override
    public _FinalStage putAllTestCases(Map<TestCaseId, TestCaseGrade> testCases) {
      this.testCases.putAll(testCases);
      return this;
    }

    @Override
    @JsonSetter(
        value = "testCases",
        nulls = Nulls.SKIP
    )
    public _FinalStage testCases(Map<TestCaseId, TestCaseGrade> testCases) {
      this.testCases.clear();
      this.testCases.putAll(testCases);
      return this;
    }

    @Override
    public GradedResponseV2 build() {
      return new GradedResponseV2(submissionId, testCases);
    }
  }
}