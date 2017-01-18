package crm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crm.entity.Customer;
import crm.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean isValid(String arg1, String arg2) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User where username= :param1 and password= :param2",User.class);
		theQuery.setParameter("param1", arg1);
		theQuery.setParameter("param2", arg2);
		
		// For debug use
		System.out.println(theQuery.getResultList().get(0));
		
		return theQuery.getResultList().isEmpty()?false:true;
	}

}
