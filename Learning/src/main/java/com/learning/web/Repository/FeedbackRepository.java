package com.learning.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.web.Entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
