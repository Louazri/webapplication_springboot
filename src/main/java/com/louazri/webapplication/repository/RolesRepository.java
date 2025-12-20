package com.louazri.webapplication.repository;

import com.louazri.webapplication.model.BaseEntity;
import com.louazri.webapplication.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer>{

  Roles getByRoleName(String roleName);
}
