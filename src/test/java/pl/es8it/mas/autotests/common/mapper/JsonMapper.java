package pl.es8it.mas.autotests.common.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UncheckedIOException;
import java.lang.reflect.Type;

public final class JsonMapper {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonMapper() {
    }

    public static String toJson(Object value) {
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static <T> T fromJson(String json, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static Object convert(Object value, Type type) {
        return OBJECT_MAPPER.convertValue(value, OBJECT_MAPPER.constructType(type));
    }
}
