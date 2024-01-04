package spring_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_app.entities.Students;

public interface StudentsDao extends JpaRepository<Students, Integer> {

}
