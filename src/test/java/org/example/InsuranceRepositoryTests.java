/*package org.example;

import org.assertj.core.api.Assertions;
import org.example.insurance.Insurance;
import org.example.insurance.InsuranceRepository;
import org.example.product.ProductRepository;
import org.example.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import org.example.user.User;
import org.example.product.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class InsuranceRepositoryTests {
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddNewInsurance() {
        User user = new User();
        Product product = new Product();
        Insurance insurance = new Insurance();

        user.setFirstName("Karel");
        user.setLastName("Černý");
        user.setStreet("Bottova 8");
        user.setCity("Praha");
        user.setPostcode("45678");
        user.setEmail("karel.cerny@gmail.com");
        user.setTelephoneNumber("00420987654321");
        User savedUser = userRepository.save(user);

        product.setProductName("Pojištění odpovědnosti v soukromém životě");
        Product savedProduct = productRepository.save(product);

        insurance.setValue(450);
        insurance.setValidityFrom("15.4.2022");
        insurance.setValidityTo("30.4.2022");
        Insurance savedInsurance = insuranceRepository.save(insurance);

        // assertions
        Assertions.assertThat(savedInsurance).isNotNull();
        Assertions.assertThat(savedInsurance.getInsuranceId()).isGreaterThan(0);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getUserId()).isGreaterThan(0);
        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getProductId()).isGreaterThan(0);
    }

}
*/