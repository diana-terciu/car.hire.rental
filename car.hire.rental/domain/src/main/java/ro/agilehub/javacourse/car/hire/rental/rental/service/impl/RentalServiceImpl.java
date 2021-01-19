package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.manager.CarManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.manager.UserManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

	private final UserManager userManager;
	private final CarManager carManager;
	private final RentalManager rentalManager;

	@Override
	public Integer createNewRental(RentalDO example) {
		var userResponse = userManager.getById(example.getUser().getId());
		var carResponse = carManager.getById(example.getCar().getId());
		if (userResponse.isPresent() && carResponse.isPresent()) {
			return rentalManager.save(example);
		}
		throw new NoSuchElementException();
	}

	@Override
	public List<RentalDO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
