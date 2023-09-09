package com.seed.trace.resources.submission.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TracedFile.Builder.class)
public final class TracedFile {
    private final String filename;

    private final String directory;

    private TracedFile(String filename, String directory) {
        this.filename = filename;
        this.directory = directory;
    }

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("directory")
    public String getDirectory() {
        return directory;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TracedFile && equalTo((TracedFile) other);
    }

    private boolean equalTo(TracedFile other) {
        return filename.equals(other.filename) && directory.equals(other.directory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.filename, this.directory);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FilenameStage builder() {
        return new Builder();
    }

    public interface FilenameStage {
        DirectoryStage filename(String filename);

        Builder from(TracedFile other);
    }

    public interface DirectoryStage {
        _FinalStage directory(String directory);
    }

    public interface _FinalStage {
        TracedFile build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FilenameStage, DirectoryStage, _FinalStage {
        private String filename;

        private String directory;

        private Builder() {}

        @Override
        public Builder from(TracedFile other) {
            filename(other.getFilename());
            directory(other.getDirectory());
            return this;
        }

        @Override
        @JsonSetter("filename")
        public DirectoryStage filename(String filename) {
            this.filename = filename;
            return this;
        }

        @Override
        @JsonSetter("directory")
        public _FinalStage directory(String directory) {
            this.directory = directory;
            return this;
        }

        @Override
        public TracedFile build() {
            return new TracedFile(filename, directory);
        }
    }
}