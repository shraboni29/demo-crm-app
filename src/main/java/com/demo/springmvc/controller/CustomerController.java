package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springmvc.DAO.CustomerDao;
import com.demo.springmvc.Entity.Customer;
import com.demo.springmvc.service.CustomerService;
@Controller
public class CustomerController {

//@Autowired
//public CustomerDao customerDao;
@Autowired
public CustomerService customerService;

@GetMapping("/showCustomer")
public String  showCustomer(Model model)

{
	//getting customer from dao
//List<Customer> theCustomer=customerDao.getCustomer();
	//getting customer from service
		List<Customer> theCustomer=customerService.getCustomer();
	
	model.addAttribute("customers",theCustomer);
	
	return "list-customer";
}


@GetMapping("/addCustomer")
public String  addCustomer(Model model)

{
Customer c1=new Customer();
model.addAttribute("customer",c1);

return "customer-form";

}

@GetMapping("/saveCustomer")
public String  saveCustomer (@ModelAttribute ("customer") Customer c2 )

{

	customerService.saveCustomerImp(c2);
	
	
	

return "redirect:/showCustomer";


}
@GetMapping("/updateCustomer")
public String updateCustomer(@RequestParam ("customerId") int theid , Model model)
{
Customer theCustomer=customerService.getCustomer(theid);
model.addAttribute("customer",theCustomer);
return "customer-form";

}

@GetMapping("/deleteCustomer")

public String delete (@RequestParam ("customerMId") int theid)
{
	customerService.deleteCustomer(theid);
	return  "redirect:/showCustomer";
	
	
}


@GetMapping("/search")
public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                Model theModel) {

    // search customers from the service
    List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
            
    // add the customers to the model
    theModel.addAttribute("customers", theCustomers);

    return "list-customer";        
}
}

