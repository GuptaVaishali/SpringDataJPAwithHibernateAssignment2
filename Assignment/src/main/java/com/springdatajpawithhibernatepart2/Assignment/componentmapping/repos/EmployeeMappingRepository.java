package com.springdatajpawithhibernatepart2.Assignment.componentmapping.repos;

import com.springdatajpawithhibernatepart2.Assignment.componentmapping.entities.EmployeeMapping;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeMappingRepository extends CrudRepository<EmployeeMapping,Integer> {
}
