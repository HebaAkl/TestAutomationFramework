package backend.graphiql.service;


import backend.graphiql.GraphqlQuery;
import models.User;

public class UserMutationService {

    private GraphqlQuery graphQLQuery = new GraphqlQuery();

    public GraphqlQuery createUser(User user) {
        graphQLQuery.setQuery("mutation userCreation ($email: String!){" +
                "  createUser(email: $email){" +
                "    user{" +
                "      userEmail" +
                "      userName" +
                "    }" +
                "    errors{" +
                "    }" +
                "  }" +
                "}");

        graphQLQuery.setVariables(user);

        return graphQLQuery;
    }

}
