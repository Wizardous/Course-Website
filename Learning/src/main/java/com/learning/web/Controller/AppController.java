package com.learning.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.learning.web.Entity.Course;
import com.learning.web.Entity.User;
import com.learning.web.Repository.CourseRepository;
import com.learning.web.Service.CourseService;
import com.learning.web.Service.UserService;

@Controller
public class AppController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/admin/dashboard")
	public String viewAdminDashboardPage() {
		return "admin_dashboard";
	}
	
	@GetMapping("/user/dashboard")
	public String viewUserDahsboardPage() {
		return "user_dashboard";
	}

	
	

}
