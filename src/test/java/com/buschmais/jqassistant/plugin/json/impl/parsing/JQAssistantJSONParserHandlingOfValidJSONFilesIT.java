package com.buschmais.jqassistant.plugin.json.impl.parsing;

import java.io.InputStream;
import java.util.Collection;

import com.buschmais.jqassistant.plugin.json.impl.parsing.generated.JSONLexer;
import com.buschmais.jqassistant.plugin.json.impl.parsing.generated.JSONParser;

import org.antlr.v4.runtime.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class JQAssistantJSONParserHandlingOfValidJSONFilesIT {

    private String pathToJSONFile;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return DataProvider.validOwnExamples();
    }

    public JQAssistantJSONParserHandlingOfValidJSONFilesIT(String path) {
        pathToJSONFile = path;
    }

    @Test
    public void canParseValidJSONFile() throws Exception {
        try (InputStream inputStream = getClass().getResourceAsStream(pathToJSONFile)) {
            JSONLexer l = new JQAssistantJSONLexer(CharStreams.fromStream(inputStream), pathToJSONFile);
            JSONParser p = new JQAssistantJSONParser(new CommonTokenStream(l), pathToJSONFile);
            p.document();
        }
    }

 }