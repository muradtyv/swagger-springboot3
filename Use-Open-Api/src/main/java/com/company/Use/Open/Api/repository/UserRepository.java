package com.company.Use.Open.Api.repository;

import com.company.Use.Open.Api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
