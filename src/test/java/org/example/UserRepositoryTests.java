package org.example;

import org.assertj.core.api.Assertions;
import org.example.user.User;
import org.example.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

/** Annotation for a JPA (Java Persistence API - it's a specification which is part of Java EE and defines an API for
 * object-relational mappings and for managing persistent objects. You can use this API in Java SE and Java EE
 * environments.) test that focuses only on JPA components. Using this annotation will disable full auto-configuration
 * and instead apply only configuration relevant to JPA tests. By default, tests annotated with @DataJpaTest are
 * transactional and roll back at the end of each test. They also use an embedded in-memory database (replacing any
 * explicit or usually auto-configured DataSource) */
@DataJpaTest
/** Annotation to run test against real database.
 * Replace determines what type of existing DataSource bean can be replaced. */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
/** A test annotation that is used to indicate whether a test-managed transaction should be rolled back after the test
 * method has completed. It means that we will keep the data in the database. */
@Rollback(false)
public class UserRepositoryTests {
    /** Autowiring happens by placing an instance of one bean into the desired field in an instance of another bean.
     * Both classes should be beans (A bean is an object that is instantiated, assembled, and otherwise managed by a
     * Spring IoC container.).
     * A reference autowired to the UserRepository interface. */
    @Autowired private UserRepository repo;

    @Test
    public void testAddNewUser() {
        User user = new User();
        user.setCity("Praha");
        user.setEmail("eliska.cintula@email.cz");
        user.setFirstName("Eliska");
        user.setPostcode("12345");
        user.setLastName("Cintula");
        user.setStreet("Lesnicka 3");
        user.setTelephoneNumber("00420123456800");

        User savedUser = repo.save(user);

        // assertions
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getUserId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> users = repo.findAll();

        //assertions
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUser() {
        Long userId = 1L;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setFirstName("Tatiana");
        repo.save(user);

        User updatedUser = repo.findById(userId).get();

        // assertions
        Assertions.assertThat(updatedUser.getFirstName()).isEqualTo("Tatiana");
    }

    @Test
    public void testGetUser() {
        Long userId = 4L;
        Optional<User> optionalUser = repo.findById(userId);
        System.out.println(optionalUser.get());

        // assertions
        Assertions.assertThat(optionalUser).isPresent();
    }

    @Test
    public void testDeleteUserById() {
        Long userId = 4L;
        repo.deleteById(userId);
        Optional<User> optionalUser = repo.findById(userId);

        // assertions
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
