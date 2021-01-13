package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import io.github.resilience4j.core.lang.NonNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
public class CarDO {
	
	@NonNull
    private Integer id;

}
