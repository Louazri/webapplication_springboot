package com.louazri.webapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

/*
@data annotation is provided by lombok library which generates getter , setter , eauls(),hashCode(),toString() methods
& Constructor at compile time . this makes our code short and clean .
 */
@Slf4j
@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;

   @NotBlank(message = "Name must not be blank")
    @Size(min = 3 , message = "Name must be at least 3 characters long")
    private String name;

   @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNum;

   @NotBlank(message = "Mobile number must not be blank")
    @Email(message = "please provide a valid email address")
    private String email;

   @NotBlank(message = "Subject must not be blank")
    @Size(min = 5 ,message = "Subject  must be at least 5 charachters long")
    private String subject;

   @NotBlank(message = "Message must not be blank")
    @Size(min = 10, message = "Message must be al least 10 characters long")
    private String message;

   private String status;

}
