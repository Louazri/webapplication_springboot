package com.louazri.webapplication.repository;

import com.louazri.webapplication.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
