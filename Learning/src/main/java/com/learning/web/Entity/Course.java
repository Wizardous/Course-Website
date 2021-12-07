package com.learning.web.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String courseName;

	@Column(name = "resource_url")
	private String courseResourceUrl;

	@Column(name = "description")
	private String courseDescription;
	
	@ManyToMany
	@JoinTable(
			name="users_enrolled",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="student_id")
	)
	private Set<User> enrolledUsers = new HashSet<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseResourceUrl() {
		return courseResourceUrl;
	}

	public void setCourseResourceUrl(String courseResourceUrl) {
		this.courseResourceUrl = courseResourceUrl;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public Set<User> getEnrolledUsers() {
		return enrolledUsers;
	}

	public void setEnrolledUsers(Set<User> enrolledUsers) {
		this.enrolledUsers = enrolledUsers;
	}

	public void enrolleUser(User user) {
		enrolledUsers.add(user);
		
	}

}
