package org.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** Service indicate that it's holding the business logic. */
@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public List<User> listAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User get(Long userId){
        Optional<User> result = userRepository.findById(userId);
            return result.get();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
