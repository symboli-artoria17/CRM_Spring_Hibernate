package crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crm.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	@Transactional
	public boolean isValid(String arg1, String arg2) {
		
		return userDAO.isValid(arg1, arg2);
	}

}
