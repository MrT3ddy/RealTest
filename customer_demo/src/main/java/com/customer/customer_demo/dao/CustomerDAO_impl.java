package com.customer.customer_demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customer.customer_demo.customerEntity.Customer;
@Repository
public class CustomerDAO_impl implements CustomerDAO {

	private EntityManager entityManager;
	
	@Autowired  //injection
	public CustomerDAO_impl(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	
	@Override
	public List<Customer> findAll() {
		//get session
		Session currentSession = entityManager.unwrap(Session.class);
		//create query
		Query<Customer> que = currentSession.createQuery("from Customer", Customer.class);
		//execute query to get list
		List<Customer> cus = que.getResultList();

		// return list
		return cus;
	}
	

	@Override
	public Customer findById(int theId) {
		Session sesh = entityManager.unwrap(Session.class);
		
		Customer cus = sesh.get(Customer.class, theId);
		
		// gets customer based off passed in "theId"
		
		return cus;
	}
	
	@Override
	public void save(Customer theCustomer) {
		Session sesh = entityManager.unwrap(Session.class);
		
		sesh.saveOrUpdate(theCustomer);
		
		// saves customer
		
	}
	
	@Override
	public void delete(int id) {  
		
		Session sesh = entityManager.unwrap(Session.class);
		
		Query que = sesh.createQuery("delete from Customer where customer_id=:id");
		// mySQL query to delete customer
		// (self note) delete from "Customer" is the entity class (not table name from mySql workbench)
		
		
		que.setParameter("id" , id);
		// sets passed value to customer_id used above in the query
		
		que.executeUpdate();
		
		//ends update
	}
	

}
