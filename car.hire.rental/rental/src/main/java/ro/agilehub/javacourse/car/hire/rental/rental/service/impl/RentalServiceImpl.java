package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.RentalEntity;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.RentalEntityRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.mapper.RentalDOMapper;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

	private final RentalDOMapper rentalDOMapper;
	private final UserApi userApi;
	private final CarApi carApi;

	private final RentalEntityRepository rentalRepository;


	@Override
	public Integer createNewRental(RentalDO example) {
		ResponseEntity<UserDTO> userResponse = userApi.getUser(example.getUser().getId());
		ResponseEntity<CarDTO> carResponse = carApi.getCarById(example.getCar().getId());
		RentalEntity newRental = rentalDOMapper.rentalDoToRental(example);
		newRental = rentalRepository.save(newRental);
		return newRental.getId();
	}

	@Override
	public List<RentalDO> findAll() {
		List<RentalDO> result = rentalDOMapper.toRentalDOList(rentalRepository.findAll());

		if (result.isEmpty()) {
			throw new NoSuchElementException();
		}

		return result;
	}

}
