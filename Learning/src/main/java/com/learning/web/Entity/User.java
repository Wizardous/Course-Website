package com.learning.web.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "role")
	private String role;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", nullable = false)
	private String email;

	
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "phone")
	private String phone;
	
	private Boolean enabled = true;
	
	
	@ManyToMany(mappedBy = "enrolledUsers")
	private Set<Course> enrolledCourses = new HashSet<>();



//	TODO : Add avatar feature for user profile
//	private String avatar_url;

	public Set<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(Set<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	
	
	

//	TODO : Add when avatar feature ready
//	public String getAvatar_url() {
//		return avatar_url;
//	}

//	TODO : Add when avatar feature ready
//	public void setAvatar_url(String avatar_url) {
//		this.avatar_url = avatar_url;
//	}

}
