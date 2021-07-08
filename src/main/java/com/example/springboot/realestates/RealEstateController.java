package com.example.springboot.realestates;
// import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/real-estate") 
// @RestController
public class RealEstateController {
	@Autowired 
	private RealEstateRepository realEstateRepository;

	@GetMapping(path="")
	public @ResponseBody Iterable<RealEstate> getAllUsers() {
	  // This returns a JSON or XML with the users
	  return realEstateRepository.findAll();
	}

}
