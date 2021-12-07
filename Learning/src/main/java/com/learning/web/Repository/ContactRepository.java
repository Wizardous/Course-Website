package com.learning.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.web.Entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
