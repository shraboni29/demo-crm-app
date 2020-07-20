package com.demo.springmvc.DAO;

import java.util.List;

import com.demo.springmvc.Entity.Customer;


public interface CustomerDao {
	public List <Customer> getCustomer();

	public void saveCustomerImp(Customer c2);

	public Customer getCustomer(int theid);

	public void deleteCustomer(int theid);

	public List<Customer> searchCustomers(String theSearchName);

	//public List<Customer> getCustomer(int theid);

	//public void getCustomer(int theid);

}
