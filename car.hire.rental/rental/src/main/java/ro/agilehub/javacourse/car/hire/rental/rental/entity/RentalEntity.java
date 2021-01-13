package ro.agilehub.javacourse.car.hire.rental.rental.entity;


import java.time.OffsetDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "rental")
@NoArgsConstructor
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;
	
    @Column(name = "car_id")
    private Integer carId;
    
	@Column(name = "rental_start_date")
	private OffsetDateTime startDate;
	
	@Column(name = "rental_end_date")
	private OffsetDateTime endDate;
	
	@Column
	@Enumerated(EnumType.STRING)
	private RentalStatus status;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

}
