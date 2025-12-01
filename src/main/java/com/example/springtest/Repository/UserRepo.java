package com.example.springtest.Repository;

import com.example.springtest.DTO.LoginRequest;
import com.example.springtest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByNID(String NID);
}
