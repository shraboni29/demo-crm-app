package com.demo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springmvc.DAO.CustomerDao;
import com.demo.springmvc.Entity.Customer;
@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	public CustomerDao customerdao;

@Transactional
	public List<Customer> getCustomer() {
		
		
		
		
		return customerdao.getCustomer();
	}
@Transactional
public void saveCustomerImp(Customer c2) {
	 customerdao.saveCustomerImp(c2);
	// TODO Auto-generated method stub
	
}
////
//public List<Customer> getCustomer(int theid) {
//	// TODO Auto-generated method stub
//	return customerdao.getCustomer(theid);
//}
@Transactional
public Customer getCustomer(int theid) {
	// TODO Auto-generated method stub
	return customerdao.getCustomer(theid);
}
@Transactional
public void deleteCustomer(int theid) {
	
	 customerdao.deleteCustomer(theid);
}
@Transactional
public List<Customer> searchCustomers(String theSearchName) {
	// TODO Auto-generated method stub
	return customerdao.searchCustomers(theSearchName) ;
}





}
