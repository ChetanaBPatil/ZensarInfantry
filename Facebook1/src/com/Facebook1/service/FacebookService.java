package com.Facebook1.service;

import com.Facebook1.dao.FacebookDAO;
import com.Facebook1.dao.FacebookDAOInterface;
import com.Facebook1.entity.FacebookEmployee;

public class FacebookService implements  FacebookServiceInterface {
	private FacebookService() {} 

	public static FacebookServiceInterface createServiceObject() {
		
		return new FacebookService();
	}

	@Override
	public int createProfile(FacebookEmployee fe) {
		FacebookDAOInterface fd=FacebookDAO.createDaoObject();
		return fd.createProfileDAO(fe);
	}

}
