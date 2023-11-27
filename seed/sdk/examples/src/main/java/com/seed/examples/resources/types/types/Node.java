/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.examples.resources.types.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.examples.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Node.Builder.class)
public final class Node {
    private final String name;

    private final Optional<List<Node>> nodes;

    private final Optional<List<Tree>> trees;

    private final Map<String, Object> additionalProperties;

    private Node(
            String name,
            Optional<List<Node>> nodes,
            Optional<List<Tree>> trees,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.nodes = nodes;
        this.trees = trees;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("nodes")
    public Optional<List<Node>> getNodes() {
        return nodes;
    }

    @JsonProperty("trees")
    public Optional<List<Tree>> getTrees() {
        return trees;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Node && equalTo((Node) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Node other) {
        return name.equals(other.name) && nodes.equals(other.nodes) && trees.equals(other.trees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.nodes, this.trees);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(Node other);
    }

    public interface _FinalStage {
        Node build();

        _FinalStage nodes(Optional<List<Node>> nodes);

        _FinalStage nodes(List<Node> nodes);

        _FinalStage trees(Optional<List<Tree>> trees);

        _FinalStage trees(List<Tree> trees);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<List<Tree>> trees = Optional.empty();

        private Optional<List<Node>> nodes = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(Node other) {
            name(other.getName());
            nodes(other.getNodes());
            trees(other.getTrees());
            return this;
        }

        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public _FinalStage trees(List<Tree> trees) {
            this.trees = Optional.of(trees);
            return this;
        }

        @Override
        @JsonSetter(value = "trees", nulls = Nulls.SKIP)
        public _FinalStage trees(Optional<List<Tree>> trees) {
            this.trees = trees;
            return this;
        }

        @Override
        public _FinalStage nodes(List<Node> nodes) {
            this.nodes = Optional.of(nodes);
            return this;
        }

        @Override
        @JsonSetter(value = "nodes", nulls = Nulls.SKIP)
        public _FinalStage nodes(Optional<List<Node>> nodes) {
            this.nodes = nodes;
            return this;
        }

        @Override
        public Node build() {
            return new Node(name, nodes, trees, additionalProperties);
        }
    }
}