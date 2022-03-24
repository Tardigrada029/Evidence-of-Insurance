package org.example.insurance;

import org.example.product.Product;
import org.example.user.User;

import javax.persistence.*;

@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(unique = true, name = "insurance_id")
    private Long insuranceId;

    @Column(nullable = false, name = "value")
    private double value;

    @Column(nullable = false, name = "validity_from")
    private String validityFrom;

    @Column(nullable = false, name = "validity_to")
    private String validityTo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable=false)
    private Product product;

    // getters and setters
    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getValidityFrom() {
        return validityFrom;
    }

    public void setValidityFrom(String validityFrom) {
        this.validityFrom = validityFrom;
    }

    public String getValidityTo() {
        return validityTo;
    }

    public void setValidityTo(String validityTo) {
        this.validityTo = validityTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceId=" + insuranceId +
                ", value='" + value + '\'' +
                ", validityFrom='" + validityFrom + '\'' +
                ", validityTo='" + validityTo + '\'' +
                ", user'" + user.getFirstName() + user.getLastName() + '\'' +
                ", product'" + product.getProductName() + '\'' +
                '}';
    }
}
