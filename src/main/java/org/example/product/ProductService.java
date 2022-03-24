package org.example.product;

import org.example.insurance.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public void save (Product product) {
        productRepository.save(product);
    }

    public Product get(Long productId) {
        Optional<Product> result = productRepository.findById(productId);
            return result.get();
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
