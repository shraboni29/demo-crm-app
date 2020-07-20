package com.demo.springmvc.service;

import java.util.List;

import com.demo.springmvc.Entity.Customer;

public interface CustomerService {
	
	
	//public List <Customer> getCustomer(int theid);

	public void saveCustomerImp(Customer c2);

	//public List<Customer> getCustomer();

	public List<Customer> getCustomer();

	public Customer getCustomer(int theid);

	public void deleteCustomer(int theid);

	public List<Customer> searchCustomers(String theSearchName);


}
