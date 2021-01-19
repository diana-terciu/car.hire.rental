package ro.agilehub.javacourse.car.hire.rental.rental.service.manager;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.rental.mapper.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.RentalEntityRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

@Component
@RequiredArgsConstructor
public class DefaultRentalManager implements RentalManager {

	private final RentalEntityRepository rentalRepository;
	private final RentalDOMapper rentalDOMapper;

	@Override
	public Integer save(RentalDO rentalDO) {
		var rentalEntity = rentalDOMapper.rentalDoToRental(rentalDO);
		rentalRepository.save(rentalEntity);
		return rentalDO.getId();
	}

}
