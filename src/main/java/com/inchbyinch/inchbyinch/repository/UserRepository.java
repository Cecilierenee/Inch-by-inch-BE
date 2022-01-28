package com.inchbyinch.inchbyinch.repository;

import com.inchbyinch.inchbyinch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //registration
    boolean existsByEmailAddress(String userEmailAddress);

    //login
    User findUserByEmailAddress(String userEmailAddress);
}
