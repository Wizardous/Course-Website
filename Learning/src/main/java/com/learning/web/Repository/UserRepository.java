package com.learning.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learning.web.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	  @Query("select u from User u where u.email = ?1")
	  User findByEmailAddress(String emailAddress);
}
