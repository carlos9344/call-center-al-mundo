package com.almundo.test;

import org.junit.Before;
import org.junit.Test;

import com.almundo.controller.CustomerController;
import com.almundo.controller.Dispatcher;
import com.almundo.controller.EmployeeController;
import com.almundo.vo.CallCenter;
import com.almundo.vo.Customer;
import com.almundo.vo.Employee;

/**
 * 
 * @author Carlos Angulo
 *
 * @param <E>
 */
public class DispatcherTest<E> {

	Dispatcher<E> d;
	int numberOfCalls;
	Customer c1;
	Employee e1;
	CallCenter<Employee> callCenter;

	/**
	 * method for setup
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		numberOfCalls = 100;
		c1 = new Customer("Claude");
		e1 = new Employee("Ramon", "operator");
		callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(e1);
		d = new Dispatcher<E>(new EmployeeController(callCenter), new CustomerController(callCenter));
	}

	/**
	 * 100 calls are executed, with a call pool size of 10. This test runs all
	 * calls by the same customer and are assigned to the same employee.
	 * 
	 * @throws InterruptedException
	 */

	public void runCalls() throws InterruptedException {
		for (int customerCallId = 1; customerCallId <= numberOfCalls; customerCallId++) {
			d.dispatchCall(customerCallId, c1);
		}
		d.terminateDispatch();
	}

	/**
	 * only one employee available to take calls
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void runOneCall() throws InterruptedException {
		d.dispatchCall(1, c1);
		d.terminateDispatch();
	}

}
