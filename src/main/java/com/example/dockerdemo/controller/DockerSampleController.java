package com.example.dockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/index")
public class DockerSampleController {

	@GetMapping("/dockermsg")
	public String getDockerMsg(){
		return "Successfully retrived Docker message";
	}
	
}
