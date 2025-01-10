package com.example.CRUDAndSecurityDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDAndSecurityDemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
}
