package com.test.rentcloud.profileservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rentcloud.commons.model.Customer;
import com.test.rentcloud.profileservice.repository.CustomerRepository;
import com.test.rentcloud.profileservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository cus;

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return cus.save(customer);
	}

	
}
