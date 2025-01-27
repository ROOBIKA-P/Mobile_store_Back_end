package com.example.mobileapp.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
    public interface AdminRepository extends JpaRepository<Admin,Integer> {
        List<Admin> findByNameContaining(String name);
        List<Admin> findByNameContainingIgnoreCase(String name);
        Optional<Admin> findByEmail(String email);
}
