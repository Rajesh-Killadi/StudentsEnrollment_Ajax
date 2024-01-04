package spring_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_app.entities.Timings;
import spring_app.service.StudentsService;

@RestController
public class StrudentsRestController {
	StudentsService service;
	@Autowired
	public void setService(StudentsService service) {
		this.service = service;
	}
	
	@GetMapping("/timings")
	public Timings findTimings(@RequestParam("courseId") String courseId) {
		
		Timings timings = service.findTimingsByTimingsId(Integer.parseInt(courseId));
		
		
		return timings;
		
		
	}


}
