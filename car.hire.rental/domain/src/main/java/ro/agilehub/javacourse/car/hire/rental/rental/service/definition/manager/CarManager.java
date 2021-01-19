package ro.agilehub.javacourse.car.hire.rental.rental.service.definition.manager;

import java.util.Optional;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;

public interface CarManager {

	Optional<CarDO> getById(Integer id);
}
