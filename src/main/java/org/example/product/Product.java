package org.example.product;

import org.example.insurance.Insurance;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(unique = true, name = "product_id")
    private Long productId;

    @Column(nullable = false, length = 120, name = "product_name")
    private String productName;

    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    private Set<Insurance> insurance;

    // getters and setters
    public Long getProductId() {return productId;}

    public void setProductId(Long productId) {this.productId = productId;}

    public String getProductName() {return productName;}

    public void setProductName(String productName) {this.productName = productName;}

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
