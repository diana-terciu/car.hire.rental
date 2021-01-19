package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.CarDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.manager.CarManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;

@Component
@RequiredArgsConstructor
public class DefaultCarManager implements CarManager {

	private final CarApi carApi;
	private final CarDOMapper carDOMapper;

	@Override
	public Optional<CarDO> getById(Integer id) {

		var carDTOResponseEntity = carApi.getCarById(id);
		return Optional.ofNullable(carDTOResponseEntity.getBody()).map(carDOMapper::toCarDO);

	}

}
