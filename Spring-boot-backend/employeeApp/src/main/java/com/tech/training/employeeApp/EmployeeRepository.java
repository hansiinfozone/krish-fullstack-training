package com.tech.training.employeeApp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);

}
