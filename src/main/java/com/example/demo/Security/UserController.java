package com.example.demo.Security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	
	
	@GetMapping("/register/new")
	public String getSignupForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("titlePage", "User Registration");
		return "register";
		
	}
	
//	register form
	@PostMapping("register/save")
//	public String submitForm(@Valid User user, 
//							Errors errors,
//							Model model) {
//		if(errors.hasErrors()){
//			return "register";
//		}
//		else {
//		
//			String encodePassword = encoder.encode(user.getPassword());
//			user.setPassword(encodePassword);
//			
//			service.saveUser(user);
//			model.addAttribute("message", "Register Successfully");
//			return "login";
//		}
//	}
	
	
	public String submitForm(@ModelAttribute("user") User user,
							HttpServletRequest request,
							Model model) throws ServletException {
		String password = user.getPassword();
		user.setPassword(encoder.encode(password));
		
		service.saveUser(user);
		request.login(user.getUsername(), password);
		model.addAttribute("message", "Register Successfully");
		return "login";
	}

	
	//show login page
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("titlePage", "Login");
		return "login";
	}

}
