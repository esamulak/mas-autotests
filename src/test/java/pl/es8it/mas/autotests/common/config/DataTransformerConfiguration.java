package pl.es8it.mas.autotests.common.config;

import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import pl.es8it.mas.autotests.common.mapper.JsonMapper;

import java.lang.reflect.Type;

public class DataTransformerConfiguration {

    @DefaultDataTableEntryTransformer
    public Object toObject(Object entry, Type type) {
        return JsonMapper.convert(entry, type);
    }

    @DefaultParameterTransformer
    public Object toParameter(String value, Type type) {
        return JsonMapper.convert(value, type);
    }
}
