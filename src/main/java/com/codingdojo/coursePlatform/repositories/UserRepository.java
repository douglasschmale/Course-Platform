package com.codingdojo.coursePlatform.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.coursePlatform.models.Role;
import com.codingdojo.coursePlatform.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
