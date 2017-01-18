package crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import crm.entity.User;
import crm.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String getLoginPage(Model theModel){
		User user = new User();
		theModel.addAttribute("loginBean",user);
		return "NewLogin";
	}
	
	@PostMapping("login")
	public String validateLogin(@ModelAttribute("loginBean") User user){
		
		return userService.isValid(user.getUsername(), user.getPassword())?"redirect:/customer/list":"LoginError";
	}
}
