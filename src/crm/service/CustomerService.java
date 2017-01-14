package crm.service;

import java.util.List;

import crm.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
}
