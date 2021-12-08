package com.learning.web.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.learning.web.Security.AppUserDetails;
import com.learning.web.Service.CourseService;
import com.learning.web.Service.UserService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	@GetMapping("/user/courses/{courseId}")
	public String getCourseDetailsPage(@PathVariable Long courseId, Model model) {
		model.addAttribute("course", courseService.getCourseById(courseId));
		return "course_details";
	}
	
	@PostMapping("/user/courses/register/{courseId}")
	public String registerUserForCourse(
			@PathVariable Long courseId,
			Model model
	) {
		Course course = courseService.getCourseById(courseId);
		model.addAttribute("course", course);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getUserByEmail(authentication.getName());
		
		course.enrolleUser(user);
		courseService.saveCourse(course);
		
		return "register_success";
	}
	
	

	@GetMapping("/admin/courses/add")
	public String getAddCoursePage(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);

		return "new_course";
	}

	@PostMapping("/admin/courses/add")
	public String addNewCourse(@ModelAttribute("course") Course course) {
		courseService.saveCourse(course);
		return "redirect:/admin/dashboard";
	}

	@GetMapping("/admin/courses/edit/{courseId}")
	public String getEditCoursePage(
			@PathVariable Long courseId,
			Model model
	) {
		Course course = courseService.getCourseById(courseId);
		model.addAttribute("course", course);
		
		return "course_edit";
	}
	
	@PostMapping("/admin/courses/edit")
	public String editCourse(@ModelAttribute("course") Course course) {
		courseService.saveCourse(course);
		return "redirect:/admin/dashboard";
	}
	
	@PostMapping("/admin/courses/delete/{courseId}")
	public String addNewCourse(@PathVariable Long courseId) {
		courseService.deleteUserById(courseId);
		return "redirect:/admin/dashboard";
	}
	
	

}
