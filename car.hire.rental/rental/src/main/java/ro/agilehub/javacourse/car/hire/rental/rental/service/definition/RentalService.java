package ro.agilehub.javacourse.car.hire.rental.rental.service.definition;

import java.util.List;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

public interface RentalService {

    Integer createNewRental(RentalDO example);
    List<RentalDO> findAll();
}
