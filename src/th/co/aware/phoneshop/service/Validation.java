package th.co.aware.phoneshop.service;

import org.springframework.beans.factory.annotation.Autowired;

import th.co.aware.phoneshop.bean.User;
import th.co.aware.phoneshop.controller.UserDAO;

public class Validation {
	@Autowired
	UserDAO userDao;
	public Boolean validUser(String username, String password)
	{
		User s = userDao.getUserByUsernameAndPassword(username, password);
		
		if(s!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
