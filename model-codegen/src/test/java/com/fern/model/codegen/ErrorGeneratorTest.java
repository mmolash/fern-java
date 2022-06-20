package com.fern.model.codegen;

import com.fern.codegen.GeneratedError;
import com.fern.java.test.TestConstants;
import com.fern.model.codegen.errors.ErrorGenerator;
import com.fern.types.errors.ErrorDefinition;
import com.fern.types.types.FernFilepath;
import com.fern.types.types.NamedType;
import com.fern.types.types.ObjectProperty;
import com.fern.types.types.ObjectTypeDefinition;
import com.fern.types.types.PrimitiveType;
import com.fern.types.types.Type;
import com.fern.types.types.TypeReference;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class ErrorGeneratorTest {

    @Test
    public void test_basic() {
        ErrorGenerator errorGenerator = new ErrorGenerator(
                ErrorDefinition.builder()
                        .name(NamedType.builder()
                                .fernFilepath(FernFilepath.valueOf("/fern"))
                                .name("NotFoundError")
                                .build())
                        .type(Type._object(ObjectTypeDefinition.builder()
                                .addProperties(ObjectProperty.builder()
                                        .key("a")
                                        .valueType(TypeReference.primitive(PrimitiveType.STRING))
                                        .build())
                                .build()))
                        .build(),
                TestConstants.GENERATOR_CONTEXT,
                Collections.emptyMap());
        GeneratedError generatedError = errorGenerator.generate();
        System.out.println(generatedError.file().toString());
    }
}