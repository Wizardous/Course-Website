package com.learning.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learning.web.Entity.Contact;
import com.learning.web.Entity.Course;
import com.learning.web.Entity.User;
import com.learning.web.Repository.CourseRepository;
import com.learning.web.Service.ContactService;
import com.learning.web.Service.CourseService;
import com.learning.web.Service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact-us")
	public String getContactUsPage(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
	
		return "contact_us.html";
	}
	
	@PostMapping("/contact-us")
	public String addNewContact(@ModelAttribute("contact")Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/";
	}
	
	@GetMapping("/contact/list")
	public String getAllContactsList(Model model) {
		model.addAttribute("contacts", contactService.getAllContacts());
	
		return "contact_list.html";
	}
	
	
}
