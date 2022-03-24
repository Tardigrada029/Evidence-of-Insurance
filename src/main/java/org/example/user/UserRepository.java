package org.example.user;

import org.springframework.data.repository.CrudRepository;

// Repository class provides the mechanism for storage, retrieval, update, delete and search operation on objects
public interface UserRepository extends CrudRepository<User, Long> {
    public Long countByUserId (Long userId);

}
