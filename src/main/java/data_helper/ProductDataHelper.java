package data_helper;

import backend.restful.repository.ProductRepository;
import com.github.javafaker.Faker;
import models.Product;

public class ProductDataHelper {
    private final ProductRepository productRepository = new ProductRepository();
    private final Faker faker = new Faker();
    public void createProduct() {
        productRepository.createProduct(buildProduct());
    }


    private Product buildProduct() {
        Product product = new Product();
        product.setTitle(faker.name().title());
        return product;
    }
}
