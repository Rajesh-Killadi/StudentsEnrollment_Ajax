package spring_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_app.entities.Timings;

public interface TimingsDao extends JpaRepository<Timings, Integer> {

	
	
}
