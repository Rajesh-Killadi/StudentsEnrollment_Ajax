package spring_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_app.entities.Courses;

public interface CoursesDao extends JpaRepository<Courses, Integer> {

}
