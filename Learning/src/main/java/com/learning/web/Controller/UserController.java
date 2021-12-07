package com.learning.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learning.web.Entity.Course;
import com.learning.web.Entity.User;
import com.learning.web.Repository.CourseRepository;
import com.learning.web.Service.CourseService;
import com.learning.web.Service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String viewSignUpPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String registerUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/user/list")
	public String getAllUsersList(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "user_list.html";
	}

}
