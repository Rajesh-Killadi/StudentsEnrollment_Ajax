package spring_app.model;

import java.util.List;

public class StudentsModel {
	
	
	private String studentName;
	private String studentEmail;
	private String gender;
	private Integer courseId;
	private List <String> timings;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public List<String> getTimings() {
		return timings;
	}
	public void setTimings(List<String> timings) {
		this.timings = timings;
	}
	@Override
	public String toString() {
		return "StudentsModel [studentName=" + studentName + ", studentEmail=" + studentEmail + ", gender=" + gender
				+ ", courseId=" + courseId + ", timings=" + timings + "]";
	}
	
	
	
	

	
	
	

}
