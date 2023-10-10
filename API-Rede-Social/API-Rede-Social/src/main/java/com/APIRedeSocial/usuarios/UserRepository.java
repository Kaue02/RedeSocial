package com.APIRedeSocial.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByDeletadoFalse();

    UserDetails findByEmail(String email);

}
