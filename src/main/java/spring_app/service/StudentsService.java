package spring_app.service;

import java.util.List;

import spring_app.entities.Courses;
import spring_app.entities.Students;
import spring_app.entities.Timings;

public interface StudentsService {

	
	boolean saveStudent(Students student);
	
	List<Courses> findCourses();
	
	Courses findCourseById(Integer courseId);
	
	Timings findTimingsByTimingsId(Integer id);
	
	void sendEmail(String to ,String subject,String body );
}
