package crm.dao;

import java.util.List;

import crm.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
}
