package com.nitinIT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitinIT.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//public Optional<User> loadUserByUsername(String username);
     // public User findByUsername(String username);

	public User findByUserName(String userName);

}
