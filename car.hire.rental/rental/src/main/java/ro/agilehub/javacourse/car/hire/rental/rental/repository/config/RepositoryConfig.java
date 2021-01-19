package ro.agilehub.javacourse.car.hire.rental.rental.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ro.agilehub.javacourse.car.hire.rental.rental.repository.RentalEntityRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = RentalEntityRepository.class)
public class RepositoryConfig {

}
