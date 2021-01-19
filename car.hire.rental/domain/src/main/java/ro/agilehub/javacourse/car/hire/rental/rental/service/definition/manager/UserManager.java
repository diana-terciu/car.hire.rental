package ro.agilehub.javacourse.car.hire.rental.rental.service.definition.manager;

import java.util.Optional;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;

public interface UserManager {

	Optional<UserDO> getById(Integer id);
}
