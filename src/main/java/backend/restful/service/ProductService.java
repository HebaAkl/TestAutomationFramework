package backend.restful.service;

import backend.CustomRestAssured;
import io.restassured.response.Response;
import models.Product;
import utilities.ConfigUtils;

public class ProductService {

    public static Response createProductService(Product product) {
        return CustomRestAssured
                .given()
                .header("token")
                .body(product)
                .enableRetry(false)
                .post(ConfigUtils.getBackendUrl());
    }
}
