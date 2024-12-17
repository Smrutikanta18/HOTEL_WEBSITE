package com.hotel.VaishnoBleach.repository;

import com.hotel.VaishnoBleach.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByEmail(String email);
}
