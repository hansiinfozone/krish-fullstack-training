package com.test.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.rentcloud.commons.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
