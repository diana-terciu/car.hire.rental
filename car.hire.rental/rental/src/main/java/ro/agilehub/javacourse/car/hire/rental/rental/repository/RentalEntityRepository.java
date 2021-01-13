package ro.agilehub.javacourse.car.hire.rental.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.agilehub.javacourse.car.hire.rental.rental.entity.RentalEntity;

@Repository
public interface RentalEntityRepository extends JpaRepository<RentalEntity, Integer> {
	

}
