package com.customer.customer_demo.dao;

import java.util.List;

import com.customer.customer_demo.customerEntity.Customer;

public interface CustomerDAO {
	
	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void delete(int theId);
}
