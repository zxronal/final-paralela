package com.poli.finalprogramacion.repository;

import com.poli.finalprogramacion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByDeletedFalse();
}