package spring_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import spring_app.entities.Courses;
import spring_app.entities.Students;
import spring_app.entities.Timings;
import spring_app.repositories.CoursesDao;
import spring_app.repositories.StudentsDao;
import spring_app.repositories.TimingsDao;

@Service
public class ServiceImpl implements StudentsService {

	private StudentsDao studentsDao;
	private CoursesDao coursesDao;
	private TimingsDao timingsDao;
	
	private JavaMailSender mailSender;
	
	@Autowired
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	public void setStudentsDao(StudentsDao studentsDao) {
		this.studentsDao = studentsDao;
	}

	@Autowired
	public void setCoursesDao(CoursesDao coursesDao) {
		this.coursesDao = coursesDao;
	}

	@Autowired
	public void setTimingsDao(TimingsDao timingsDao) {
		this.timingsDao = timingsDao;
	}

	public boolean saveStudent(Students students) {

		Students save = studentsDao.save(students);

		return save != null;

	}

	@Override
	public List<Courses> findCourses() {

		return coursesDao.findAll();
	}

	@Override
	public Timings findTimingsByTimingsId(Integer id) {

		Optional<Timings> findById = timingsDao.findById(id);

		if (findById.isPresent()) {
			Timings timings = findById.get();
			return timings;
		}
		return null;

	}

	@Override
	public Courses findCourseById(Integer courseId) {
		Optional<Courses> findById = coursesDao.findById(courseId);

		if (findById.isPresent()) {

			return findById.get();
		}

		return null;

	}

	public void sendEmail(String to, String subject, String body) {

		SimpleMailMessage mailObj = new SimpleMailMessage();
		mailObj.setTo(to);
		mailObj.setSubject(subject);
		mailObj.setText(body);

		mailSender.send(mailObj);

		System.out.println("Email sent successfully");

	}
	
}
