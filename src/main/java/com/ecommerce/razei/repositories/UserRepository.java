package com.ecommerce.razei.repositories;

import com.ecommerce.razei.models.RazeiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<RazeiUser,Long> {
    Optional<RazeiUser> findOneByUsername(String username);
}
