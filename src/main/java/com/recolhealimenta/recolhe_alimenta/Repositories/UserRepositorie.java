package com.recolhealimenta.recolhe_alimenta.Repositories;

import com.recolhealimenta.recolhe_alimenta.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorie extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
