package crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory; //sessionFactory Bean is configured in beans.xml
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session (org.hibernate.Session)
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer ... but maybe update. so instead of using only save or update, here a method that combines these two.
		
		// currentSession.save(theCustomer);
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		return currentSession.get(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		// :customerId is the paramter name
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		// bind the name with value
		theQuery.setParameter("customerId", theId);
		// just do it
		theQuery.executeUpdate();
	}

}
