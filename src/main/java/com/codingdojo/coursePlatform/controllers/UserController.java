package com.codingdojo.coursePlatform.controllers;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.coursePlatform.models.Course;
import com.codingdojo.coursePlatform.models.User;
import com.codingdojo.coursePlatform.services.UserService;

@Controller
public class UserController {
	private UserService uS;
	
	public UserController(UserService uS) {
		this.uS=uS;
	}
 
 
 @PostMapping("/registration")
 public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
     
	 if (result.hasErrors()) {
         return "loginPage.jsp";
     }
     if(uS.findByUsername(user.getUsername())!= null) {
    	 model.addAttribute("emailError","User with this email already exists.");
    	 return "loginPage.jsp";
     }
     
     uS.saveUserWithAdminRole(user);
     return "redirect:/login";
 }
 
 @RequestMapping("/login")
 public String login(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
     if(error != null) {
         model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
     }
     if(logout != null) {
         model.addAttribute("logoutMessage", "Logout Successful!");
     }
     return "loginPage.jsp";
 }

 
 @RequestMapping(value = {"/", "/home"})
 public String home(Principal principal, Model model) {
     String username = principal.getName();
     model.addAttribute("currentUser", uS.findByUsername(username).getUsername());
     System.out.println(uS.findByUsername(username).getUsername());
     return "redirect:/courses";
 }
 
 @RequestMapping("/admin")
 public String adminPage(Principal principal, Model model) {
     String username = principal.getName();
     model.addAttribute("currentUser", uS.findByUsername(username));
     return "adminPage.jsp";
 }
}