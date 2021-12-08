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
import com.learning.web.Entity.Feedback;
import com.learning.web.Entity.User;
import com.learning.web.Repository.CourseRepository;
import com.learning.web.Service.CourseService;
import com.learning.web.Service.FeedbackService;
import com.learning.web.Service.UserService;

@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/user/feedback")
	public String getFeedbackPage(Model model) {
		Feedback feedback = new Feedback();
		model.addAttribute("feedback", feedback);
		return "feedback";
	}
	
	@PostMapping("/user/feedback")
	public String addNewFeedback(@ModelAttribute("feedback") Feedback feedback) {
		feedbackService.saveFeedback(feedback);
		return "redirect:/user/dashboard";
	}
	
	@GetMapping("/admin/feedbacks/list")
	public String getAllFeedbackList(Model model) {
		model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
		return "feedback_list";
	}
	
}
