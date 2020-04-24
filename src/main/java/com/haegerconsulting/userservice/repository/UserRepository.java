package com.haegerconsulting.userservice.repository;

import com.haegerconsulting.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userName like :userName")
    Iterable<User> findByUserName(@Param("userName") String userName);
}
