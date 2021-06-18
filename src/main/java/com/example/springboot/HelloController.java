package com.example.springboot;

// import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/users") 
// @RestController
public class HelloController {
	@Autowired 
	private UserRepository userRepository;

	// @RequestMapping("/")
	// public String index() {
	// 	return "Greetings from Spring Boott!";
	// }
	@PostMapping(path="") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
		, @RequestParam String email) {
	  // @ResponseBody means the returned String is the response, not a view name
	  // @RequestParam means it is a parameter from the GET or POST request
  
	  User n = new User();
	  n.setName(name);
	  n.setEmail(email);
	  userRepository.save(n);
	  return "Saved";
	}
  
	@GetMapping(path="")
	public @ResponseBody Iterable<User> getAllUsers() {
	  // This returns a JSON or XML with the users
	  return userRepository.findAll();
	}

}