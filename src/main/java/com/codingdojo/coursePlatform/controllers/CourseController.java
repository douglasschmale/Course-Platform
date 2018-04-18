package com.codingdojo.coursePlatform.controllers;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.coursePlatform.models.Course;
import com.codingdojo.coursePlatform.models.User;
import com.codingdojo.coursePlatform.repositories.UserRepository;
import com.codingdojo.coursePlatform.controllers.UserController;
import com.codingdojo.coursePlatform.services.CourseService;
import com.codingdojo.coursePlatform.services.UserService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	private CourseService cS;
	
	public CourseController(CourseService cS) {
		this.cS=cS;
	}
	
	@RequestMapping("")
	public String courses(@ModelAttribute("course") Course course, Model model) {
		ArrayList<Course> courses = cS.all();
		model.addAttribute("courses", courses);
		return "courses.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("course") Course newCourse, BindingResult res) {
		if(res.hasErrors()) {
			return "courses.jsp";
		}
		cS.create(newCourse);
		return "redirect:/courses";	

	}
	
	@RequestMapping("/new")
	public String newCourse(@ModelAttribute("course") Course course) {
		return "newCourse.jsp";
	}
	
	@RequestMapping("/{id}/add")
	public String addToEvent(@PathVariable("id") long id, Principal principal, Model model) {
		Course thisCourse = cS.find(id);
		String currentUser = principal.getName();
//		User principalUser = UserService.findByUsername(currentUser);
//		principalUser.setCourse(thisCourse);
		return "redirect:/courses/{id}";
	}
	
	@RequestMapping("/{id}")
	public String showEvent(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("course", (Course)cS.find(id));
		
		return "showCourse.jsp";
	}
	
}
