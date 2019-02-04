package com.customer.customer_demo.session;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.customer_demo.customerEntity.Customer;
import com.customer.customer_demo.dao.CustomerDAO;
@Service
public class CustomerService_impl implements CustomerServiceLayer {
	
	
	
	
	
	private CustomerDAO customerDAO;
	// because its transaction layer we import DAO class so we can distinguish transaction to make everything neat
	
	public CustomerService_impl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	
	
	// everything bellow is self-explain
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int id) {
	
		return customerDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		
		customerDAO.save(customer);

	}

	@Override
	@Transactional
	public void delete(int theId) {
		
		customerDAO.delete(theId);

	}

}
