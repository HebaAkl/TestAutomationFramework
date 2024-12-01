package tests.backend;

import backend.restful.repository.ProductRepository;
import models.Product;
import org.testng.annotations.Test;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

public class ProductAPITest {

    @Test
    public void testProductCreation () {
        ProductRepository productRepository = new ProductRepository();
        Product productData = new Product();
        productData.setTitle("Title");
        Product actualProduct = productRepository.createProduct(productData);
        assertThatJson(actualProduct).whenIgnoringPaths("id").isEqualTo(productData);
    }
}
