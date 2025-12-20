package com.louazri.webapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    @NotBlank(message = "Address  must not be blank")
    @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    private String address1;

    private String address2;

    @NotBlank(message = "City must not be blank")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;

    @NotBlank(message = "State must not be blank")
    @Size(min = 2, max = 50, message = "State must be between 2 and 50 characters")
    private String state;

    @NotBlank(message = "Zip Code must not be blank")
    @Pattern(regexp="(^$|[0-9]{5})", message="Zip Code must be 5 digits")
    private String zipCode;

}
