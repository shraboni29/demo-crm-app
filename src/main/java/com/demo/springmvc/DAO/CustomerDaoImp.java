package com.demo.springmvc.DAO;

import java.util.List;


//import org.hibernate.Query;

//import javax.persistence.Query;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.demo.springmvc.Entity.Customer;

//import com.demo.springmvc.Entity.Customer;
//import com.mysql.cj.Query;
@Repository
@Component
public class CustomerDaoImp implements CustomerDao {

	
	//inject dependency beanid=sessionFactory
	@Autowired
	public SessionFactory sessionFactory; 
	//@Transactional
	//move this funcionality into service layer
	//transactional annotation manage all begin and commit transaction.no need to define
	public List<Customer> getCustomer() {
		//get the session
		Session session =sessionFactory.getCurrentSession();
		//create the query
		Query<Customer> q1=session.createQuery("from Customer",Customer.class);
		
		List<Customer> studentList=q1.getResultList();
		
		
		
		return studentList;
	}
	public void saveCustomerImp(Customer c2) {
		
		Session session =sessionFactory.getCurrentSession();
		//save purpose
		//session.save(c2);
		//saveorUpdate method check the id if does not exist thens save this data 
		//otherwise update this data
		session.saveOrUpdate(c2);
		
	}
	public Customer getCustomer(int theid) {
		Session session =sessionFactory.getCurrentSession();
		Customer theCustomer =session.get(Customer.class,theid);
		return theCustomer;
		
	}
	public void deleteCustomer(int theid) {
		Session session =sessionFactory.getCurrentSession();
		Query  theQuery=session.createQuery("delete from Customer where id=:customerMId");
		theQuery.setParameter("customerMId", theid);
		theQuery.executeUpdate();
		
	}
	public List<Customer> searchCustomers(String theSearchName) {
		
		Session session =sessionFactory.getCurrentSession();
Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =session.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
   
	}
	

	
	
	

}
