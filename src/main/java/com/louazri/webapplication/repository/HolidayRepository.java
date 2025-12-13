package com.louazri.webapplication.repository;

import com.louazri.webapplication.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface HolidayRepository extends CrudRepository<Holiday, String> {

}
