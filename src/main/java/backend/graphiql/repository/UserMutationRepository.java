package backend.graphiql.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import backend.CustomRestAssured;
import io.restassured.response.Response;
import models.User;
import utilities.ConfigUtils;

import static mapper.ObjectsMapper.mapJsonToObject;

public class UserMutationRepository {
    private Response response;

    public User createUser(User user) throws JsonProcessingException {
        response = CustomRestAssured
                .given()
                .header("token")
                .body(user)
                .key("errorKey")
                .trials(Integer.parseInt(ConfigUtils.getMaxTrials()))
                .post(ConfigUtils.getBackendUrl());

        return mapJsonToObject(response.asString(), User.class);
    }
}
