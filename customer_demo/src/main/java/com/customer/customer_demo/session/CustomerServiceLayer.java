package com.customer.customer_demo.session;

import java.util.List;

import com.customer.customer_demo.customerEntity.Customer;

public interface CustomerServiceLayer {
	
	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public void save(Customer customer);
	
	public void delete(int theId);
}
