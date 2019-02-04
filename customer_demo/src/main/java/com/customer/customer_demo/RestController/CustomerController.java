package com.customer.customer_demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.customer_demo.customerEntity.Customer;
import com.customer.customer_demo.session.CustomerServiceLayer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	private CustomerServiceLayer ServiceLayer;
	
	@Autowired
	public CustomerController(CustomerServiceLayer sl) {
		ServiceLayer = sl;
	}
	
	@GetMapping("/customer")
	public List<Customer> findAll() {
		return ServiceLayer.findAll();
	}
	
	@GetMapping("/customer/{id}") // {id} must be same as @PathVariable
	public Customer getCustomer(@PathVariable int id) {
		
		Customer cus = ServiceLayer.findById(id);
		// inserts customer found by method findById from service then from dao
		
		if(cus == null) {
			throw new RuntimeException(">>> Customer ID not found: " + id);
		} // null value solution
		
		
		return cus;
		
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		
		ServiceLayer.save(customer);
		
		return customer;
	}
	@PutMapping("/customer")
	public Customer update(@RequestBody Customer customer) {
			ServiceLayer.save(customer);
			
			return customer;
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
		Customer cus = ServiceLayer.findById(id);
		
		if(cus == null) {
			throw new RuntimeException(">>> Customer not found : " + id);
		}
		
		ServiceLayer.delete(id);
		
		return "Deleted Customer ID of :" + id;
	}

}
