package com.learning.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.web.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
