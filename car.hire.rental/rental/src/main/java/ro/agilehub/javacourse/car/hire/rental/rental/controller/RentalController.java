package ro.agilehub.javacourse.car.hire.rental.rental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.api.model.CreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentalApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper.RentalDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentalApi {

    private final RentalService rentalService;
    private final RentalDTOMapper rentalDTOMapper;



	
	@Override
	public ResponseEntity<CreatedDTO> addRental(@Valid RentalDTO rentalDTO) {
		var id = rentalService.createNewRental(rentalDTOMapper.toRentalDO(rentalDTO));
		return ResponseEntity.ok(new CreatedDTO().id(id));
	}
	 
    
    @Override
    public ResponseEntity<List<RentalDTO>> getRentals() {
    	return ResponseEntity.ok(rentalDTOMapper.toRentalDTOList(rentalService.findAll()));
        
    }
	/*
	 * var userDTOResponseEntity = userApi.getUser(example.getUser().getId());
	 * return 123;
	 */
}
