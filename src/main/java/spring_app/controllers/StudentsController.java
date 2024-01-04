package spring_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spring_app.entities.Courses;
import spring_app.entities.Students;
import spring_app.model.StudentsModel;
import spring_app.service.StudentsService;

@Controller
public class StudentsController {

	StudentsService service;

	@Autowired
	public void setService(StudentsService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String index(Model model) {

		StudentsModel studentsModel = new StudentsModel();
		List<Courses> courses = service.findCourses();

		model.addAttribute("courses", courses);
		model.addAttribute("studentsModel", studentsModel);

		return "index.html";

	}

	@PostMapping("/register")
	public String registerStudent(StudentsModel studentsModel, Model model) {

		System.out.println(studentsModel);

		Students student = new Students();
		student.setStudentName(studentsModel.getStudentName());
		student.setStudentEmail(studentsModel.getStudentEmail());
		
		Courses course = service.findCourseById(studentsModel.getCourseId());
		/*
		 * Courses course = new Courses();
		 * course.setCourseId(studentsModel.getCourseId());
		 */

		student.setStudentcourseId(course);
		
		

		service.saveStudent(student);

		model.addAttribute("name", studentsModel.getStudentName());
		model.addAttribute("email", studentsModel.getStudentEmail());
		model.addAttribute("gender", studentsModel.getGender());
		model.addAttribute("course", course.getCourseName());
		model.addAttribute("courseDuration", course.getCourseDuration());
		model.addAttribute("timings",studentsModel.getTimings());
		
        String body ="Your Enrollment is Completed"+",Your course timings are:"+studentsModel.getTimings();
		service.sendEmail(studentsModel.getStudentEmail(),course.getCourseName()+" Registration", body);
		
		return "success.html";

	}

}
