package com.hachehorde.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hachehorde.api.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    
}
