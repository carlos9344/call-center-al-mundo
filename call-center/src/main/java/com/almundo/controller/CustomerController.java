package com.almundo.controller;

import java.util.Deque;

import com.almundo.vo.CallCenter;
import com.almundo.vo.Customer;
import com.almundo.vo.Employee;

/**
 * This class provides the functionality to manipulate customers in the model.
 * 
 * @author Carlos Angulo
 *
 */
public class CustomerController {

	/**
	 * Call center  
	 */
	private CallCenter<Employee> callCenter;
	
	/**
	 * Customers 
	 */
	private Deque<Customer> customers;

	/**
	 * Constructor of class 	
	 * @param cc
	 */
	public CustomerController(CallCenter<Employee> cc) {
		callCenter = cc;
		customers = callCenter.getAllCustomersQueued();
	}
	
	/**
	 * get customers 
	 */
	public Deque<Customer> getCustomers() {
		return customers;
	}

	/**
	 * gets and removes the head of the collection
	 * 
	 * @return
	 */
	public Customer getNextCustomer() {
		return customers.poll();
	}

	/**
	 * inserts the customer at the beginning of the collection (head) this
	 * method is used to model the case when there are not available employees
	 * to take the call
	 * 
	 * @param c
	 */
	public void addNextCustomer(Customer c) {
		customers.offerFirst(c);
	}

}
