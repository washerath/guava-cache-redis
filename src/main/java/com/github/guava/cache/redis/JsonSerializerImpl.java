package com.github.guava.cache.redis;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

/**
 * @author wasanthah
 */
public class JsonSerializerImpl implements JsonSerializer {

    @Override
    public String serialize(Object obj) {
//        return JsonWriter.objectToJson(obj);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deserialize(String objectData) {
        return (T) JsonReader.jsonToJava(objectData);
    }

    @Override
    public <T> T deserializeV(String objectData, Class<T> vClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.registerModule(new GuavaModule());
            return (T) objectMapper.readValue(objectData, Object.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
