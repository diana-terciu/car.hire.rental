package ro.agilehub.javacourse.car.hire.rental.rental.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ro.agilehub.javacourse.car.hire.rental.rental.entity.RentalEntity;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

@Mapper(componentModel = "spring")
public interface RentalDOMapper {

	@Mapping(source = "carId", target = "car.id")
	@Mapping(source = "userId", target = "user.id")
	RentalDO rentalToRentalDo(RentalEntity optional);

	@Mapping(source = "car.id", target = "carId")
	@Mapping(source = "user.id", target = "userId")
	RentalEntity rentalDoToRental(RentalDO rentalDto);

	List<RentalDO> toRentalDOList(List<RentalEntity> rentalList);

}
