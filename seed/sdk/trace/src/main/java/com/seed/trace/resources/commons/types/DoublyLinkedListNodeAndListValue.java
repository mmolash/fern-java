/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.commons.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DoublyLinkedListNodeAndListValue.Builder.class)
public final class DoublyLinkedListNodeAndListValue {
    private final String nodeId;

    private final DoublyLinkedListValue fullList;

    private final Map<String, Object> additionalProperties;

    private DoublyLinkedListNodeAndListValue(
            String nodeId, DoublyLinkedListValue fullList, Map<String, Object> additionalProperties) {
        this.nodeId = nodeId;
        this.fullList = fullList;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("nodeId")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("fullList")
    public DoublyLinkedListValue getFullList() {
        return fullList;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DoublyLinkedListNodeAndListValue && equalTo((DoublyLinkedListNodeAndListValue) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DoublyLinkedListNodeAndListValue other) {
        return nodeId.equals(other.nodeId) && fullList.equals(other.fullList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nodeId, this.fullList);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NodeIdStage builder() {
        return new Builder();
    }

    public interface NodeIdStage {
        FullListStage nodeId(String nodeId);

        Builder from(DoublyLinkedListNodeAndListValue other);
    }

    public interface FullListStage {
        _FinalStage fullList(DoublyLinkedListValue fullList);
    }

    public interface _FinalStage {
        DoublyLinkedListNodeAndListValue build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NodeIdStage, FullListStage, _FinalStage {
        private String nodeId;

        private DoublyLinkedListValue fullList;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(DoublyLinkedListNodeAndListValue other) {
            nodeId(other.getNodeId());
            fullList(other.getFullList());
            return this;
        }

        @Override
        @JsonSetter("nodeId")
        public FullListStage nodeId(String nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        @Override
        @JsonSetter("fullList")
        public _FinalStage fullList(DoublyLinkedListValue fullList) {
            this.fullList = fullList;
            return this;
        }

        @Override
        public DoublyLinkedListNodeAndListValue build() {
            return new DoublyLinkedListNodeAndListValue(nodeId, fullList, additionalProperties);
        }
    }
}
