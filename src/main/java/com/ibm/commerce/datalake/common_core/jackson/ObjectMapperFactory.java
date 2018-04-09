/*******************************************************************************
 * IBM Confidential
 * OCO Source Materials
 * 5725-S87, 5725-W69
 * © Copyright IBM Corp. 2017
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been
 * deposited with the U.S. Copyright Office.
 *******************************************************************************/
package com.ibm.commerce.datalake.common_core.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Factory for producing new ObjectMapper instances .
 *
 */
public final class ObjectMapperFactory {


    public static ObjectMapper getNewObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

    public static JsonFactory getJSONFactory() {
        return new JsonFactory();
    }

    public static JsonNode isJsonValid(String jsonMsg) throws IOException {
        JsonNode kafkaMsgNode = null;
        try {
            ObjectMapper mapper = new ObjectMapper();

            kafkaMsgNode = mapper.readTree(jsonMsg);
        } catch (IOException ioExp) {
            throw ioExp;
        }
        return kafkaMsgNode;

    }

    private ObjectMapperFactory() {
        super();
    }

}
