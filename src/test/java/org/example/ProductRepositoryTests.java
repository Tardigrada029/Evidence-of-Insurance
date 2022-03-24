package org.example;

import org.assertj.core.api.Assertions;
import org.example.product.Product;
import org.example.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddNewProduct() {
        Product product = new Product();
        product.setProductName("Životní pojištění");

        Product savedProduct = productRepository.save(product);

        // assertions
        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getProductId()).isGreaterThan(0);
    }

    @Test
    public void testListAllProducts() {
        Iterable<Product> products = productRepository.findAll();

        //assertions
        Assertions.assertThat(products).hasSizeGreaterThan(0);

        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void testUpdateProduct() {
        Long productId = 1L;
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product product = optionalProduct.get();
        product.setProductName("Cestovní pojištění");
        productRepository.save(product);

        Product updatedProduct = productRepository.findById(productId).get();

        // assertions
        Assertions.assertThat(updatedProduct.getProductName()).isEqualTo("Cestovní pojištění");
    }

    @Test
    public void testGetProduct() {
        Long productId = 1L;
        Optional<Product> optionalProduct = productRepository.findById(productId);
        System.out.println(optionalProduct.get());

        // assertions
        Assertions.assertThat(optionalProduct).isPresent();
    }

    @Test
    public void testDeleteProductById() {
        Long productId = 1L;
        productRepository.deleteById(productId);
        Optional<Product> optionalProduct = productRepository.findById(productId);

        // assertions
        Assertions.assertThat(optionalProduct).isNotPresent();
    }
}
