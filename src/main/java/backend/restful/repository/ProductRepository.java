package backend.restful.repository;

import io.restassured.response.Response;
import models.Product;

import static backend.restful.service.ProductService.createProductService;
import static mapper.ObjectsMapper.mapJsonToObject;

public class ProductRepository {

    public Product createProduct(Product product) {
        Response response = createProductService(product);
        return mapJsonToObject(response.asString(), Product.class);
    }
}
