package com.sb21java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb21java.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
