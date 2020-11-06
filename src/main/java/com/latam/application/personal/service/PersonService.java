package com.latam.application.personal.service;

import java.util.List;

import com.latam.application.personal.model.PersonDTO;
import com.latam.application.personal.model.PoemDTO;

public interface PersonService {

	PersonDTO getPerson(String name, String lastName, String birthday);
	
	PoemDTO[] getPoems();

	 	
}
