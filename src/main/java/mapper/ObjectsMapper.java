package mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.io.IOException;

public class ObjectsMapper {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public ObjectsMapper() {
    }

    public static <T> T mapJsonToObject(String json, Class<T> mapperClass) {
        try {
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
            return objectMapper.readValue(json, mapperClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String convertObjectToString(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String convertedString = objectMapper.writeValueAsString(object);
        return convertedString;
    }
}
